/*
 * Copyright 2013 Goodow.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goodow.realtime.json.impl;

import com.goodow.realtime.json.JsonArray;
import com.goodow.realtime.json.JsonType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Server-side implementation of JsonArray.
 */
public class JreJsonArray extends JreJsonElement implements JsonArray {
  private static final long serialVersionUID = -4799870976276999803L;

  @SuppressWarnings("unchecked")
  static List<Object> convertList(List<?> list) {
    List<Object> arr = new ArrayList<Object>(list.size());
    for (Object obj : list) {
      if (obj instanceof Map) {
        arr.add(JreJsonObject.convertMap((Map<String, Object>) obj));
      } else if (obj instanceof List) {
        arr.add(convertList((List<?>) obj));
      } else {
        arr.add(obj);
      }
    }
    return arr;
  }

  protected List<Object> list;

  public JreJsonArray() {
    this.list = new ArrayList<Object>();
  }

  public JreJsonArray(List<Object> array) {
    this.list = array;
  }

  public JreJsonArray(String jsonString) {
    list = JacksonUtil.decodeValue(jsonString, List.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public JsonArray clear() {
    if (needsCopy) {
      list = new ArrayList<Object>();
      needsCopy = false;
    } else {
      list.clear();
    }
    return this;
  }

  @SuppressWarnings("unchecked")
  @Override
  public JsonArray copy() {
    JreJsonArray copy = new JreJsonArray(list);
    // We actually do the copy lazily if the object is subsequently mutated
    copy.needsCopy = true;
    return copy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    JreJsonArray that = (JreJsonArray) o;

    if (this.list.size() != that.list.size()) {
      return false;
    }

    Iterator<?> iter = that.list.iterator();
    for (Object entry : this.list) {
      Object other = iter.next();
      if (!entry.equals(other)) {
        return false;
      }
    }
    return true;
  }

  @Override
  @SuppressWarnings({"unchecked", "rawtypes"})
  public <T> T get(int index) {
    Object value = list.get(index);
    if (value instanceof Map) {
      value = new JreJsonObject((Map) value);
    } else if (value instanceof List) {
      value = new JreJsonArray((List) value);
    }
    return (T) value;
  }

  @Override
  public JreJsonArray getArray(int index) {
    @SuppressWarnings("unchecked")
    List<Object> l = (List<Object>) list.get(index);
    return l == null ? null : new JreJsonArray(l);
  }

  @Override
  public boolean getBoolean(int index) {
    return (Boolean) list.get(index);
  }

  @Override
  public double getNumber(int index) {
    return ((Number) list.get(index)).doubleValue();
  }

  @Override
  public JreJsonObject getObject(int index) {
    @SuppressWarnings("unchecked")
    Map<String, Object> m = (Map<String, Object>) list.get(index);
    return m == null ? null : new JreJsonObject(m);
  }

  @Override
  public String getString(int index) {
    return (String) list.get(index);
  }

  @Override
  public JsonType getType(int index) {
    return super.getType(list.get(index));
  }

  @Override
  public int indexOf(Object value) {
    return list.indexOf(value);
  }

  @Override
  public JsonArray insert(int index, Object value) {
    checkCopy();
    if (value instanceof JreJsonObject) {
      value = ((JreJsonObject) value).map;
    } else if (value instanceof JreJsonArray) {
      value = ((JreJsonArray) value).list;
    }
    list.add(index, value);
    return this;
  }

  @Override
  public int length() {
    return list.size();
  }

  @Override
  public JsonArray push(boolean bool_) {
    checkCopy();
    list.add(bool_);
    return this;
  }

  @Override
  public JsonArray push(double number) {
    checkCopy();
    list.add(number);
    return this;
  }

  @Override
  public JsonArray push(Object value) {
    checkCopy();
    if (value instanceof JreJsonObject) {
      value = ((JreJsonObject) value).map;
    } else if (value instanceof JreJsonArray) {
      value = ((JreJsonArray) value).list;
    }
    list.add(value);
    return this;
  }

  @Override
  public JsonArray remove(int index) {
    checkCopy();
    list.remove(index);
    return this;
  }

  @Override
  public String toJsonString() {
    return JacksonUtil.encode(this.list);
  }

  @Override
  public List<Object> toNative() {
    return list;
  }

  private void checkCopy() {
    if (needsCopy) {
      // deep copy the list lazily if the object is mutated
      list = convertList(list);
      needsCopy = false;
    }
  }
}