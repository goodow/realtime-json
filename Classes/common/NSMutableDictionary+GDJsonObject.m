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
//  NSMutableDictionary+GDJsonObject.m
//  GDJson
//
//  Created by Larry Tin.
//

#import "NSMutableDictionary+GDJsonObject.h"

@implementation NSMutableDictionary (GDJsonObject)

#pragma mark - JsonObject mutable methods
- (id<GDJsonObject>)set:(NSString *)key boolean:(BOOL)bool_ {
  [self set:key value:[NSNumber numberWithBool:bool_]];
  return self;
}
- (id<GDJsonObject>)set:(NSString *)key number:(double)number {
  [self set:key value:[NSNumber numberWithDouble:number]];
  return self;
}
- (id<GDJsonObject>)set:(NSString *)key value:(id)value {
  [self setValue:value == nil ? [NSNull null] : value forKey:key];
  return self;
}

- (id<GDJsonObject>)clear {
  [self removeAllObjects];
  return self;
}
- (id<GDJsonObject>)remove:(NSString *)key {
  [self removeObjectForKey:key];
  return self;
}

@end
