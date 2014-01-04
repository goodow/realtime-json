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
package com.goodow.realtime.json.impl;

import com.goodow.realtime.json.JsonElement;
import com.goodow.realtime.json.JsonException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;
import java.util.Map;

public class Xml {
  private static final JacksonXmlModule module = new JacksonXmlModule();
  private static final XmlMapper mapper;
  static {
    module.setDefaultUseWrapper(false);
    mapper = new XmlMapper(module);
  }

  @SuppressWarnings("unchecked")
  public static <T extends JsonElement> T parse(String xml) {
    Object value = decodeXml(xml, Object.class);
    if (value instanceof Map) {
      return (T) new JreJsonObject((Map<String, Object>) value);
    } else if (value instanceof List) {
      return (T) new JreJsonArray((List<Object>) value);
    } else {
      throw new JsonException("Can't parse XML string: " + xml);
    }
  }

  public static String toXml(Object obj) {
    if (obj instanceof JreJsonElement) {
      obj = ((JreJsonElement) obj).toNative();
    }
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new JsonException("Failed to encode as XML: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private static <T> T decodeXml(String xml, Class<?> clazz) throws JsonException {
    try {
      return (T) mapper.readValue(xml, clazz);
    } catch (Exception e) {
      throw new JsonException("Can't parse XML string: " + e.getMessage());
    }
  }
}