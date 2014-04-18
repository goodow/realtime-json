/*
 * Copyright 2014 Goodow.com
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
package com.goodow.realtime.json.util;

import com.goodow.realtime.json.JsonElement;
import com.goodow.realtime.json.JsonException;
import com.goodow.realtime.json.impl.JreJsonArray;
import com.goodow.realtime.json.impl.JreJsonElement;
import com.goodow.realtime.json.impl.JreJsonObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.List;
import java.util.Map;

public class Yaml {
  private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

  @SuppressWarnings("unchecked")
  public static <T extends JsonElement> T parse(String yaml) {
    Object value = decodeYaml(yaml, Object.class);
    if (value instanceof Map) {
      return (T) new JreJsonObject((Map<String, Object>) value);
    } else if (value instanceof List) {
      return (T) new JreJsonArray((List<Object>) value);
    } else {
      throw new JsonException("Can't parse YAML string: " + yaml);
    }
  }

  public static String toYaml(Object obj) {
    if (obj instanceof JreJsonElement) {
      obj = ((JreJsonElement) obj).toNative();
    }
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new JsonException("Failed to encode as YAML: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private static <T> T decodeYaml(String yaml, Class<?> clazz) throws JsonException {
    try {
      return (T) mapper.readValue(yaml, clazz);
    } catch (Exception e) {
      throw new JsonException("Can't parse YAML string: " + e.getMessage());
    }
  }
}