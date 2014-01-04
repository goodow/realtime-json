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