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

import com.goodow.realtime.json.JsonArray;
import com.goodow.realtime.json.JsonType;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Client-side implementation of JsonArray.
 */
public final class JsJsonArray extends JsJsonElement implements JsonArray {
  private static final long serialVersionUID = -8395506929193541582L;

  public static JsonArray create() {
    return (JsJsonArray) JavaScriptObject.createArray();
  }

  protected JsJsonArray() {
  }

  @SuppressWarnings("unchecked")
  @Override
  // @formatter:off
  public native JsJsonArray clear() /*-{
    this.length = 0;
    return this;
  }-*/;
  // @formatter:on

  @SuppressWarnings("unchecked")
  @Override
  public JsonArray copy() {
    return JsJsonElement.copy(this);
  }

  @Override
  // @formatter:off
  public native <T> void forEach(ListIterator<T> handler) /*-{
    if (Array.prototype.forEach) {
      Array.prototype.forEach.call(this, function(item, index, array) {
        handler.
        @com.goodow.realtime.json.JsonArray.ListIterator::call(ILjava/lang/Object;)
        (index, item);
      });
    } else {
      var len = this.length;  // must be fixed during loop...
      for (var i = 0; i < len; i++) {
        handler.
        @com.goodow.realtime.json.JsonArray.ListIterator::call(ILjava/lang/Object;)
        (i, this[i]);
      }
    }
  }-*/;
  // @formatter:on

  @SuppressWarnings("unchecked")
  @Override
  public JsJsonElement get(int index) {
    return get0(index).cast();
  }

  @Override
  public JsJsonArray getArray(int index) {
    return (JsJsonArray) get(index);
  }

  @Override
  // @formatter:off
  public native boolean getBoolean(int index) /*-{
    return this[index];
  }-*/;

  @Override
  public native double getNumber(int index) /*-{
    return this[index];
  }-*/;
  // @formatter:on

  @Override
  public JsJsonObject getObject(int index) {
    return (JsJsonObject) get(index);
  }

  @Override
  // @formatter:off
  public native String getString(int index) /*-{
    return this[index];
  }-*/;
  // @formatter:on

  @Override
  public JsonType getType(int index) {
    return get0(index).getType();
  }

  @Override
  // @formatter:off
  public native int indexOf(Object value) /*-{
    return this.indexOf(value);
  }-*/;

  @Override
  public native JsonArray insert(int index, Object element) /*-{
    this.splice(index, 0, element);
    return this;
  }-*/;

  @Override
  public native int length() /*-{
    return this.length;
  }-*/;

  @Override
  public native JsonArray push(boolean bool_) /*-{
    this[this.length] = Object(bool_);
    return this;
  }-*/;

  @Override
  public native JsonArray push(double number) /*-{
    this[this.length] = Object(number);
    return this;
  }-*/;

  @Override
  public native JsonArray push(Object element) /*-{
    this[this.length] = element;
    return this;
  }-*/;

  @Override
  public native JsonArray remove(int index) /*-{
    this.splice(index, 1);
    return this;
  }-*/;

  private native JsJsonValue get0(int index) /*-{
    return this[index];
  }-*/;
  // @formatter:on
}