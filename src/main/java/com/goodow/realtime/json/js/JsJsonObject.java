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

import com.goodow.realtime.json.JsonObject;
import com.goodow.realtime.json.JsonType;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Client-side implementation of JsonObject interface.
 */
public final class JsJsonObject extends JsJsonElement implements JsonObject {

  public static JsJsonObject create() {
    return JavaScriptObject.createObject().cast();
  }

  protected JsJsonObject() {
  }

  @Override
  public JsJsonElement get(String key) {
    return get0(key).cast();
  }

  @Override
  public JsJsonArray getArray(String key) {
    return (JsJsonArray) get(key);
  }

  @Override
  // @formatter:off
  public native boolean getBoolean(String key) /*-{
    return this[key];
  }-*/;

  @Override
  public native double getNumber(String key) /*-{
    return this[key];
  }-*/;
  // @formatter:on

  @Override
  public JsJsonObject getObject(String key) {
    return (JsJsonObject) get0(key);
  }

  @Override
  // @formatter:off
  public native String getString(String key) /*-{
    return this[key];
  }-*/;
  // @formatter:on

  @Override
  public JsonType getType(String key) {
    return get0(key).getType();
  }

  @Override
  // @formatter:off
  public native boolean has(String key) /*-{
    return key in this;
  }-*/;
  // @formatter:on

  @Override
  public String[] keys() {
    JsArrayString str = keys0();
    return reinterpretCast(str);
  }

  @Override
  // @formatter:off
  public native JsonObject remove(String key) /*-{
    delete this[key];
    return this;
  }-*/;
  
  @Override
  public native JsonObject set(String key, boolean bool_) /*-{
    this[key] = Object(bool_);
    return this;
  }-*/;

  @Override
  public native JsonObject set(String key, double number) /*-{
    this[key] = Object(number);
    return this;
  }-*/;

  @Override
  public native JsonObject set(String key, Object element) /*-{
    this[key] = element;
    return this;
  }-*/;

  private native JsJsonValue get0(String key) /*-{
    return this[key];
  }-*/;
  
  private native JsArrayString keys0() /*-{
    var keys = [];
    for(var key in this) {
      if (Object.prototype.hasOwnProperty.call(this, key) && key != '$H') {
        keys.push(key);
      }
    }
    return keys;
  }-*/;
  
  private native String[] reinterpretCast(JsArrayString arrayString) /*-{
    return arrayString;
  }-*/;
  // @formatter:on
}