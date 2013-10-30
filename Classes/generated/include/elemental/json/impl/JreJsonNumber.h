//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//
//  Created by Larry Tin <dev@goodow.com>
//

#ifndef _ElementalJsonImplJreJsonNumber_H_
#define _ElementalJsonImplJreJsonNumber_H_

@class ElementalJsonImplJsonContext;
@class ElementalJsonImplJsonVisitor;
@class GDJsonTypeEnum;
@protocol GDJsonValue;

#import "JreEmulation.h"
#include "elemental/json/JsonNumber.h"
#include "elemental/json/impl/JreJsonValue.h"

@interface ElementalJsonImplJreJsonNumber : ElementalJsonImplJreJsonValue < GDJsonNumber > {
 @public
  double number_;
}

- (id)initWithDouble:(double)number;
- (BOOL)asBoolean;
- (double)asNumber;
- (NSString *)asString;
- (double)getNumber;
- (id)getObject;
- (GDJsonTypeEnum *)getType;
- (BOOL)jsEquals:(id<GDJsonValue>)value;
- (void)traverseWithElementalJsonImplJsonVisitor:(ElementalJsonImplJsonVisitor *)visitor
                withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (NSString *)toJson;
- (void)copyAllFieldsTo:(ElementalJsonImplJreJsonNumber *)other;
@end

#endif // _ElementalJsonImplJreJsonNumber_H_