// Copyright 2013 Goodow.com. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

//
//  NSDictionary+GDJsonObject.m
//  GDJson
//
//  Created by Larry Tin.
//

#import "NSDictionary+GDJsonObject.h"
#import "IOSClass.h"
#import "java/lang/ClassCastException.h"
#import "java/lang/UnsupportedOperationException.h"

@implementation NSDictionary (GDJsonObject)

#pragma mark - JsonElement
- (BOOL)isArray {
  return NO;
}
- (BOOL)isObject {
  return YES;
}
- (NSString *)toJsonString {
  return [GDJson toJsonString:self];
}
-(NSString *)description {
  return [self toJsonString];
}
- (id<GDJsonArray>)asArray {
  @throw [[JavaLangClassCastException alloc] init];
}
- (id<GDJsonObject>)asObject {
  return self;
}

#pragma mark - JsonObject
- (id)get:(NSString *)key {
  id value = [self objectForKey:key];
  return value == [NSNull null] ? nil : value;
}
- (id)getWithNSString:(NSString *)key {
  return [self get:key];
}
- (id<GDJsonArray>)getArray:(NSString *)key {
  return [self get:key];
}
- (BOOL)getBoolean:(NSString *)key {
  return [((NSNumber *)[self get:key]) boolValue];
}
- (double)getNumber:(NSString *)key {
  return [((NSNumber *)[self get:key]) doubleValue];
}
- (id<GDJsonObject>)getObject:(NSString *)key {
  return [self get:key];
}
- (NSString *)getString:(NSString *)key {
  return [self get:key];
}

- (GDJsonTypeEnum *)getType:(NSString *)key {
  return [GDJson getType:[self get:key]];
}

- (BOOL)has:(NSString *)key {
  return [self objectForKey:key] != nil;
}
- (IOSObjectArray *)keys {
  return [IOSObjectArray arrayWithNSArray:[self allKeys] type:[IOSClass classWithClass:[NSString class]]];
}

#pragma mark - Mutable JsonObject
- (id<GDJsonObject>)set:(NSString *)key boolean:(BOOL)bool_ {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
- (id<GDJsonObject>)set:(NSString *)key number:(double)number {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
- (id<GDJsonObject>)set:(NSString *)key value:(id)value {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}

- (id<GDJsonObject>)clear {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
- (id<GDJsonObject>)remove:(NSString *)key {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}

@end
