realtime-json [![Build Status](https://travis-ci.org/goodow/realtime-json.svg?branch=master)](https://travis-ci.org/goodow/realtime-json)
======

Minimalistic JSON library for Java/Android/iOS/GWT/J2ObjC

Visit [Google groups](https://groups.google.com/forum/#!forum/goodow-realtime) for discussions and announcements.

## Requires

### Java and Android:

* [Jackson databind](https://github.com/FasterXML/jackson-databind)

These are just a few of the major dependencies, the entire list of dependencies
is listed in the [project's POM file](https://github.com/goodow/realtime-json/blob/master/pom.xml).

### Javascript and GWT:

* [Browser-native window.JSON](http://caniuse.com/json)


## Installation and Usage

### Java and Android:
Maven

```xml
<repositories>
  <repository>
    <id>sonatype-nexus-snapshots</id>
    <name>Sonatype Nexus Snapshots</name>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    <releases>
      <enabled>false</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
<dependencies>
  <dependency>
    <groupId>com.goodow.realtime</groupId>
    <artifactId>realtime-json</artifactId>
    <version>0.5.5-SNAPSHOT</version>
  </dependency>
</dependencies>
```

### iOS/Mac OS X and J2ObjC:

See: https://github.com/goodow/GDJson
