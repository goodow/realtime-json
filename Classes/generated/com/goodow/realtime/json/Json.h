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
//  Json.h
//  GDJson
//
//  Created by Larry Tin.
//

#ifndef _GDJson_H_
#define _GDJson_H_

@protocol GDJsonArray;
@protocol GDJsonObject;
@class GDJsonTypeEnum;

#import "JreEmulation.h"

@interface GDJson : NSObject {
}

+ (id<GDJsonArray>)createArray;
+ (id<GDJsonObject>)createObject;
+ (id)parseWithNSString:(NSString *)jsonString;
+ (NSString *)toJsonString:(id)element;
+ (GDJsonTypeEnum *)getType:(id)value;
+ (id)copy:(id)element;
@end

typedef GDJson ComGoodowRealtimeJsonJson;

#endif // _GDJson_H_
