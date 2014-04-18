package com.goodow.realtime.json.util;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.LinkedHashMap;

class XmlModule extends JacksonXmlModule {
  @JacksonXmlRootElement(localName = "xml")
  interface MixIn {
  }

  private static final long serialVersionUID = -7370171785293471021L;

  @Override
  public void setupModule(SetupContext context) {
    super.setupModule(context);
    context.setMixInAnnotations(LinkedHashMap.class, MixIn.class);
  }
}
