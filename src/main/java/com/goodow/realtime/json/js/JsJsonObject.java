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
  private static final long serialVersionUID = -5864296191395989510L;

  public static JsJsonObject create() {
    return JavaScriptObject.createObject().cast();
  }

  protected JsJsonObject() {
  }

  @SuppressWarnings("unchecked")
  @Override
  // @formatter:off
  public native JsJsonObject clear() /*-{
    for (var key in this) {
      if (Object.prototype.hasOwnProperty.call(this, key)) {
        delete this[key];
      }
    }
    return this;
  }-*/;
  // @formatter:on

  @SuppressWarnings("unchecked")
  @Override
  public JsonObject copy() {
    return JsJsonElement.copy(this);
  }

  @Override
  // @formatter:off
  public native <T> void forEach(Iterator<T> handler) /*-{
    for (key in this) {
      if (Object.prototype.hasOwnProperty.call(this, key)) {
        handler.
        @com.goodow.realtime.json.JsonObject.Iterator::call(Ljava/lang/String;Ljava/lang/Object;)
        (key, this[key]);
      }
    }
  }-*/;
  // @formatter:on

  @SuppressWarnings("unchecked")
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
  // TODO: We still have problem with "__proto__"
  public native JsonObject set(String key, Object element) /*-{
    this[key] = element;
    return this;
  }-*/;

  /**
   * Returns the size of the map (the number of keys).
   *
   * <p>NB: This method is currently O(N) because it iterates over all keys.
   *
   * @return the size of the map.
   */
  @Override
  public final native int size() /*-{
    size = 0;
    for (key in this) {
      if (Object.prototype.hasOwnProperty.call(this, key)) {
        size++;
      }
    }
    return size;
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