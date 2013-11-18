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

import com.goodow.realtime.json.js.JsJsonArray;
import com.goodow.realtime.json.js.JsJsonObject;

public class Json {
  public static JsonArray createArray() {
    return JsJsonArray.create();
  }

  public static JsonObject createObject() {
    return JsJsonObject.create();
  }

  public static <T> T parse(String jsonString) throws JsonException {
    try {
      return parse0(jsonString);
    } catch (Exception e) {
      throw new JsonException("Can't parse JSON string: " + e.getMessage());
    }
  }

  // @formatter:off
  private native static <T> T parse0(String jsonString) /*-{
    // assume Chrome, safe and non-broken JSON.parse impl
    return $wnd.JSON.parse(jsonString);
  }-*/;
  // @formatter:on
}