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
package com.goodow.realtime.json;

import com.goodow.realtime.json.impl.JacksonUtil;

import org.junit.Assert;
import org.junit.Test;

public class JsonObjectTest {

  @Test
  public void testNumber() {
    JsonObject obj = Json.createObject();
    Number num = 6.3;
    obj.set("num1", 3.3);
    obj.set("num2", num);
    Assert.assertEquals(3.3, obj.getNumber("num1"), 0.01);
    Assert.assertEquals(6.3, obj.getNumber("num2"), 0.01);
    JsonElement parse = Json.parse("{}");

    Object decodeValue = JacksonUtil.decodeValue(" {} ", Object.class);
  }
}