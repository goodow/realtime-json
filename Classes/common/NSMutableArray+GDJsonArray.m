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
//  NSMutableArray+GDJsonArray.m
//  GDJson
//
//  Created by Larry Tin.
//

#import "NSMutableArray+GDJsonArray.h"

@implementation NSMutableArray (GDJsonArray)

#pragma mark - JsonArray mutable methods
- (id<GDJsonArray>)insert:(int)index value:(id)value {
  [self insertObject:value == nil ? [NSNull null] : value atIndex:index];
  return self;
}

- (id<GDJsonArray>)pushBoolean:(BOOL)bool_ {
  [self push:[NSNumber numberWithBool:bool_]];
  return self;
}
- (id<GDJsonArray>)pushNumber:(double)number {
  [self push:[NSNumber numberWithDouble:number]];
  return self;
}
- (id<GDJsonArray>)push:(id)value {
  [self addObject:value == nil ? [NSNull null] : value];
  return self;
}

- (id<GDJsonArray>)clear {
  [self removeAllObjects];
  return self;
}
- (id<GDJsonArray>)remove:(int)index {
  [self removeObjectAtIndex:index];
  return self;
}

@end
