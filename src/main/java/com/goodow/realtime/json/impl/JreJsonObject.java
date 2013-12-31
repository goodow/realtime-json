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

import com.goodow.realtime.json.JsonObject;
import com.goodow.realtime.json.JsonType;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Server-side implementation of JsonObject.
 */
public class JreJsonObject extends JreJsonElement implements JsonObject {
  private static final long serialVersionUID = -2848796364089017455L;
  final Map<String, Object> map;

  public JreJsonObject() {
    this.map = new LinkedHashMap<String, Object>();
  }

  public JreJsonObject(Map<String, Object> map) {
    this.map = map;
  }

  public JreJsonObject(String jsonString) {
    map = JacksonUtil.decodeValue(jsonString, Map.class);
  }

  @Override
  public JsonObject clear() {
    map.clear();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    JreJsonObject that = (JreJsonObject) o;

    if (this.map.size() != that.map.size()) {
      return false;
    }

    for (Map.Entry<String, Object> entry : this.map.entrySet()) {
      Object val = entry.getValue();
      if (val == null) {
        if (that.map.get(entry.getKey()) != null) {
          return false;
        }
      } else {
        if (!entry.getValue().equals(that.map.get(entry.getKey()))) {
          return false;
        }
      }
    }
    return true;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public <T> T get(String key) {
    Object value = map.get(key);
    if (value instanceof Map) {
      value = new JreJsonObject((Map) value);
    } else if (value instanceof List) {
      value = new JreJsonArray((List) value);
    }
    return (T) value;
  }

  @Override
  public JreJsonArray getArray(String key) {
    @SuppressWarnings("unchecked")
    List<Object> l = (List<Object>) map.get(key);
    return l == null ? null : new JreJsonArray(l);
  }

  @Override
  public boolean getBoolean(String key) {
    return (Boolean) map.get(key);
  }

  @Override
  public double getNumber(String key) {
    return ((Number) map.get(key)).doubleValue();
  }

  @Override
  public JreJsonObject getObject(String key) {
    @SuppressWarnings("unchecked")
    Map<String, Object> m = (Map<String, Object>) map.get(key);
    return m == null ? null : new JreJsonObject(m);
  }

  @Override
  public String getString(String key) {
    return (String) map.get(key);
  }

  @Override
  public JsonType getType(String key) {
    return super.getType(map.get(key));
  }

  @Override
  public boolean has(String key) {
    return map.containsKey(key);
  }

  @Override
  public String[] keys() {
    return map.keySet().toArray(new String[map.size()]);
  }

  @Override
  public JsonObject remove(String key) {
    map.remove(key);
    return this;
  }

  @Override
  public JsonObject set(String key, boolean bool_) {
    map.put(key, bool_);
    return this;
  }

  @Override
  public JsonObject set(String key, double number) {
    map.put(key, number);
    return this;
  }

  @Override
  public JsonObject set(String key, Object value) {
    if (value instanceof JreJsonObject) {
      value = ((JreJsonObject) value).map;
    } else if (value instanceof JreJsonArray) {
      value = ((JreJsonArray) value).list;
    }
    map.put(key, value);
    return this;
  }

  @Override
  public String toJsonString() {
    return JacksonUtil.encode(this.map);
  }
}