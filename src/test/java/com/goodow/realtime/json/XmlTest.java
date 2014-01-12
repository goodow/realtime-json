package com.goodow.realtime.json;

import com.goodow.realtime.json.impl.xml.Xml;

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

    xml =
        "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>12345678</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>2</ArticleCount><Articles><item><Title><![CDATA[title1]]></Title> <Description><![CDATA[description1]]></Description><PicUrl><![CDATA[picurl1]]></PicUrl><Url><![CDATA[url1]]></Url></item><item><Title><![CDATA[title2]]></Title><Description><![CDATA[description2]]></Description><PicUrl><![CDATA[picurl2]]></PicUrl><Url><![CDATA[url2]]></Url></item></Articles></xml>";
    JsonElement parse = Xml.parse(xml);
  }
}
