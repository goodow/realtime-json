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
package com.goodow.realtime.json.js;

import com.goodow.realtime.json.JsonElement;
import com.goodow.realtime.json.JsonException;
import com.goodow.realtime.json.JsonType;

abstract class JsJsonElement extends JsJsonValue implements JsonElement {
  protected JsJsonElement() {
  }

  @Override
  public final JsJsonArray asArray() {
    return this.cast();
  }

  @Override
  public final JsJsonObject asObject() {
    return this.cast();
  }

  @Override
  public final boolean isArray() {
    return getType() == JsonType.ARRAY;
  }

  @Override
  public final boolean isObject() {
    return getType() == JsonType.OBJECT;
  }

  @Override
  public final String toJsonString() {
    try {
      return super.toJson();
    } catch (Exception e) {
      throw new JsonException("Failed to encode as JSON: " + e.getMessage());
    }
  }
}