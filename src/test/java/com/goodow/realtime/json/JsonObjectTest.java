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

import java.util.Arrays;

public class JsonObjectTest {
  static class Bean {
    public String str;
    public boolean bool;
    public Bean bean;

    Bean(String str, boolean bool, Bean bean) {
      this.str = str;
      this.bool = bool;
      this.bean = bean;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Bean other = (Bean) obj;
      if (bean == null) {
        if (other.bean != null) {
          return false;
        }
      } else if (!bean.equals(other.bean)) {
        return false;
      }
      if (bool != other.bool) {
        return false;
      }
      if (str == null) {
        if (other.str != null) {
          return false;
        }
      } else if (!str.equals(other.str)) {
        return false;
      }
      return true;
    }
  }

  @Test
  public void testConvert() {
    String[] a = {"a", "bc"};
    JsonArray array = JacksonUtil.convert(a);
    Assert.assertEquals(Json.createArray().push("a").push("bc"), array);

    Number[] b = {9., 4.};
    array = JacksonUtil.convert(b);
    Assert.assertEquals(Json.createArray().push(9).push(4), array);

    Bean bean1 = new Bean("def", false, null);
    Bean bean2 = new Bean("abc", true, bean1);
    JsonObject obj = JacksonUtil.convert(bean2);
    JsonObject obj1 = Json.createObject().set("str", "def").set("bool", false).set("bean", null);
    JsonObject obj2 = Json.createObject().set("str", "abc").set("bool", true).set("bean", obj1);
    Assert.assertEquals(obj2, obj);

    JsonArray ac = obj.keys();

    array = JacksonUtil.convert(Arrays.asList(bean1, bean2));
    Assert.assertEquals(Json.createArray().push(obj1).push(obj2), array);
  }

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