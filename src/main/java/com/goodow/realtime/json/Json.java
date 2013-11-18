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
package com.goodow.realtime.json;

import com.goodow.realtime.json.impl.JacksonUtil;
import com.goodow.realtime.json.impl.JreJsonArray;
import com.goodow.realtime.json.impl.JreJsonObject;

import java.util.List;
import java.util.Map;

public class Json {
  public static JsonArray createArray() {
    return new JreJsonArray();
  }

  public static JsonObject createObject() {
    return new JreJsonObject();
  }

  @SuppressWarnings("unchecked")
  public static <T> T parse(String jsonString) {
    Object value = JacksonUtil.decodeValue(jsonString, Object.class);
    if (value instanceof Map) {
      return (T) new JreJsonObject((Map<String, Object>) value);
    } else if (value instanceof List) {
      return (T) new JreJsonArray((List<Object>) value);
    } else {
      return (T) value;
    }
  }
}