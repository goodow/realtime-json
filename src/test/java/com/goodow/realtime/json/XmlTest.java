package com.goodow.realtime.json;

import com.goodow.realtime.json.impl.Xml;

import org.junit.Test;

public class XmlTest {
  @Test
  public void testParse() {
    String xml =
        "<xml><ToUserName><![CDATA[toUser]]></ToUserName> <FromUserName><![CDATA[fromUser]]></FromUserName>  <CreateTime>1348831860</CreateTime> <MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content> <MsgId>1234567890123456</MsgId> </xml>";
    JsonElement parseXml = Xml.parse(xml);
    String jsonString = parseXml.toJsonString();

    JsonObject obj =
        Json.createObject().set("a", "3").set("alist", Json.createArray().push("b").push("c"));
    String xml2 = Xml.toXml(obj);
  }
}
