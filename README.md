realtime-json [![Build Status](https://travis-ci.org/goodow/realtime-json.svg?branch=master)](https://travis-ci.org/goodow/realtime-json)
======

Minimalistic JSON library for Java/Android/iOS/GWT/J2ObjC


## Requires

### Java and Android:

* [Jackson databind](https://github.com/FasterXML/jackson-databind)

These are just a few of the major dependencies, the entire list of dependencies
is listed in the [project's POM file](https://github.com/goodow/realtime-json/blob/master/pom.xml).

### iOS/Mac and J2ObjC:

* [iOS 5.0 and later](https://developer.apple.com/library/ios/documentation/Foundation/Reference/NSJSONSerialization_Class/Reference/Reference.html)
* [OS X v10.7 and later](https://developer.apple.com/library/mac/documentation/Foundation/Reference/NSJSONSerialization_Class/Reference/Reference.html)

For J2ObjC, using these options when translating:
j2objc --mapping [method-mappings.properties](https://github.com/goodow/realtime/blob/master/resources/j2objc/method-mappings.properties)
 --prefixes [package-prefixes.properties](https://github.com/goodow/realtime/blob/master/resources/j2objc/package-prefixes.properties)

### Javascript and GWT:

* [Browser-native window.JSON](http://caniuse.com/json)


## Installation and Usage

### Java and Android:
Maven

```xml
<dependency>
  <groupId>com.goodow.realtime</groupId>
  <artifactId>realtime-json</artifactId>
  <version>0.5.0</version>
</dependency>
```

### iOS/Mac and J2ObjC:

[CocoaPods](http://cocoapods.org) is the recommended way to add GDJson to your project.

1. Add a pod entry for GDJson to your Podfile `pod 'GDJson', '~> 0.5'`
2. Install the pod(s) by running `pod install`.
3. Include GDJson wherever you need it with `#import "GDJson.h"`.
