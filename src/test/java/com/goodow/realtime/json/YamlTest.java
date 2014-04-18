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

import com.goodow.realtime.json.util.Yaml;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class YamlTest {
  @Test
  public void testParse() throws FileNotFoundException {
    String yaml =
        new Scanner(getClass().getResourceAsStream("/sample.yaml")).useDelimiter("\\Z").next();
    JsonElement json = Yaml.parse(yaml);
    String jsonString = json.toJsonString();

    JsonObject obj =
        Json.createObject().set("a", "3").set("alist", Json.createArray().push("b").push("c"));
    String yaml2 = Yaml.toYaml(obj);
  }
}
