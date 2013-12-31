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
//  NSArray+GDJsonArray.m
//  GDJson
//
//  Created by Larry Tin.
//

#import "NSArray+GDJsonArray.h"
#import "java/lang/ClassCastException.h"
#import "java/lang/UnsupportedOperationException.h"

@implementation NSArray (GDJsonArray)

#pragma mark - JsonElement
- (id<GDJsonArray>)asArray {
  return self;
}
- (id<GDJsonObject>)asObject {
  @throw [[JavaLangClassCastException alloc] init];
}
- (BOOL)isArray {
  return YES;
}
- (BOOL)isObject {
  return NO;
}
- (NSString *)toJsonString {
  return [GDJson toJsonString:self];
}
-(NSString *)description {
  return [self toJsonString];
}

#pragma mark - JsonArray
- (id)get:(int)index {
  id value = [self objectAtIndex:index];
  return value == [NSNull null] ? nil : value;
}
- (id)getWithInt:(int)index {
  return [self get:index];
}
- (id<GDJsonArray>)getArray:(int)index {
  return [self get:index];
}
- (BOOL)getBoolean:(int)index {
  return [((NSNumber *)[self get:index]) boolValue];
}
- (double)getNumber:(int)index {
  return [((NSNumber *)[self get:index]) doubleValue];
}
- (id<GDJsonObject>)getObject:(int)index {
  return [self get:index];
}
- (NSString *)getString:(int)index {
  return [self get:index];
}

- (GDJsonTypeEnum *)getType:(int)index {
  return [GDJson getType:[self get:index]];
}

#pragma mark - Mutable JsonArray
- (id<GDJsonArray>)insert:(int)index value:(id)value {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
- (id<GDJsonArray>)pushBoolean:(BOOL)bool_ {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
- (id<GDJsonArray>)pushNumber:(double)number {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
- (id<GDJsonArray>)push:(id)value {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}

- (id<GDJsonArray>)clear {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
- (id<GDJsonArray>)remove:(int)index {
  @throw [[JavaLangUnsupportedOperationException alloc] init];
}
@end
