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
//  Json.m
//  GDJson
//
//  Created by Larry Tin.
//

#import "com/goodow/realtime/json/Json.h"
#import "java/lang/IllegalArgumentException.h"
#import "IOSClass.h"
#import "GDJson.h"

@implementation GDJson

+ (id<GDJsonArray>)createArray {
  return [[NSMutableArray alloc] init];
}

+ (id<GDJsonObject>)createObject {
  return [[NSMutableDictionary alloc] init];
}

+ (id)parseWithNSString:(NSString *)jsonString {
  NSError *error = nil;
  id json = [NSJSONSerialization JSONObjectWithData:[jsonString dataUsingEncoding:NSUTF8StringEncoding]
                                            options:NSJSONReadingMutableContainers | NSJSONReadingAllowFragments
                                              error:&error];
  if (!json) {
    @throw [[GDJsonException alloc] initWithNSString:[NSString stringWithFormat:@"Can't parse JSON string: %@", error]];
  } else {
    return json;
  }
}

+ (NSString *)toJsonString:(id)element {
  NSError *error;
  NSData *jsonData = [NSJSONSerialization dataWithJSONObject:element
                                                     options:0
                                                       error:&error];
  if (!jsonData) {
    @throw [[GDJsonException alloc] initWithNSString:[NSString stringWithFormat:@"Failed to encode as JSON: %@", error]];
  } else {
    return [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
  }
}

+ (GDJsonTypeEnum *)getType:(id)value {
  if ([value isKindOfClass:[NSDictionary class]]) {
    return [GDJsonTypeEnum OBJECT];
  } else if ([value isKindOfClass:[NSArray class]]) {
    return [GDJsonTypeEnum ARRAY];
  } else if ([value isKindOfClass:[NSString class]]) {
    return [GDJsonTypeEnum STRING];
  } else if ([value isKindOfClass:[NSNumber class]]) {
    return [GDJsonTypeEnum NUMBER];
  } else if (value == nil) {
    return [GDJsonTypeEnum NULL_];
  }
  @throw [[JavaLangIllegalArgumentException alloc] initWithNSString:[NSString stringWithFormat:@"Invalid JSON type: %@", [[nil_chk(value) getClass] getName]]];
}

@end
