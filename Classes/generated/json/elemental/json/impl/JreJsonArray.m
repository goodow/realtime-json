//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//
//  Created by Larry Tin <dev@goodow.com>
//

#include "elemental/json/JsonArray.h"
#include "elemental/json/JsonBoolean.h"
#include "elemental/json/JsonFactory.h"
#include "elemental/json/JsonNull.h"
#include "elemental/json/JsonNumber.h"
#include "elemental/json/JsonObject.h"
#include "elemental/json/JsonString.h"
#include "elemental/json/JsonType.h"
#include "elemental/json/JsonValue.h"
#include "elemental/json/impl/JreJsonArray.h"
#include "elemental/json/impl/JreJsonValue.h"
#include "elemental/json/impl/JsonArrayContext.h"
#include "elemental/json/impl/JsonContext.h"
#include "elemental/json/impl/JsonUtil.h"
#include "elemental/json/impl/JsonVisitor.h"
#include "java/lang/Double.h"
#include "java/lang/StringBuilder.h"
#include "java/util/ArrayList.h"
#include "java/util/List.h"

@implementation ElementalJsonImplJreJsonArray

- (id)initWithGDJsonFactory:(id<GDJsonFactory>)factory {
  if (self = [super init]) {
    arrayValues_ = [[JavaUtilArrayList alloc] init];
    self->factory_ = factory;
  }
  return self;
}

- (BOOL)asBoolean {
  return YES;
}

- (double)asNumber {
  switch ([self length]) {
    case 0:
    return 0;
    case 1:
    return [((id<GDJsonValue>) nil_chk([self getWithInt:0])) asNumber];
    default:
    return JavaLangDouble_NaN;
  }
}

- (NSString *)asString {
  JavaLangStringBuilder *toReturn = [[JavaLangStringBuilder alloc] init];
  for (int i = 0; i < [self length]; i++) {
    if (i > 0) {
      (void) [toReturn appendWithNSString:@", "];
    }
    (void) [toReturn appendWithNSString:[((id<GDJsonValue>) nil_chk([self getWithInt:i])) asString]];
  }
  return [toReturn description];
}

- (id<GDJsonValue>)getWithInt:(int)index {
  return [((JavaUtilArrayList *) nil_chk(arrayValues_)) getWithInt:index];
}

- (id<GDJsonArray>)getArray:(int)index {
  return (id<GDJsonArray>) check_protocol_cast([self getWithInt:index], @protocol(GDJsonArray));
}

- (BOOL)getBoolean:(int)index {
  return [((id<GDJsonBoolean>) nil_chk([self getWithInt:index])) getBoolean];
}

- (double)getNumber:(int)index {
  return [((id<GDJsonNumber>) nil_chk([self getWithInt:index])) getNumber];
}

- (id<GDJsonObject>)getObject:(int)index {
  return (id<GDJsonObject>) check_protocol_cast([self getWithInt:index], @protocol(GDJsonObject));
}

- (id)getObject {
  id<JavaUtilList> objs = [[JavaUtilArrayList alloc] init];
  for (id<GDJsonValue> __strong val in arrayValues_) {
    [objs addWithId:[((ElementalJsonImplJreJsonValue *) nil_chk(val)) getObject]];
  }
  return objs;
}

- (NSString *)getString:(int)index {
  return [((id<GDJsonString>) nil_chk([self getWithInt:index])) getString];
}

- (GDJsonTypeEnum *)getType {
  return [GDJsonTypeEnum ARRAY];
}

- (BOOL)jsEquals:(id<GDJsonValue>)value {
  return [nil_chk([self getObject]) isEqual:[((ElementalJsonImplJreJsonValue *) nil_chk(value)) getObject]];
}

- (int)length {
  return [((JavaUtilArrayList *) nil_chk(arrayValues_)) size];
}

- (void)remove:(int)index {
  (void) [((JavaUtilArrayList *) nil_chk(arrayValues_)) removeWithInt:index];
}

- (void)set:(int)index value:(id<GDJsonValue>)value {
  if (value == nil) {
    value = [((id<GDJsonFactory>) nil_chk(factory_)) createNull];
  }
  if (index == [((JavaUtilArrayList *) nil_chk(arrayValues_)) size]) {
    [arrayValues_ addWithInt:index withId:value];
  }
  else {
    (void) [arrayValues_ setWithInt:index withId:value];
  }
}

- (void)set:(int)index string:(NSString *)string {
  [self set:index value:[((id<GDJsonFactory>) nil_chk(factory_)) createWithNSString:string]];
}

- (void)set:(int)index number:(double)number {
  [self set:index value:[((id<GDJsonFactory>) nil_chk(factory_)) createWithDouble:number]];
}

- (void)set:(int)index boolean:(BOOL)bool_ {
  [self set:index value:[((id<GDJsonFactory>) nil_chk(factory_)) createWithBoolean:bool_]];
}

- (NSString *)toJson {
  return [ElementalJsonImplJsonUtil stringifyWithGDJsonValue:self];
}

- (void)traverseWithElementalJsonImplJsonVisitor:(ElementalJsonImplJsonVisitor *)visitor
                withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx {
  if ([((ElementalJsonImplJsonVisitor *) nil_chk(visitor)) visitWithGDJsonArray:self withElementalJsonImplJsonContext:ctx]) {
    ElementalJsonImplJsonArrayContext *arrayCtx = [[ElementalJsonImplJsonArrayContext alloc] initWithGDJsonArray:self];
    for (int i = 0; i < [self length]; i++) {
      [arrayCtx setCurrentIndexWithInt:i];
      if ([visitor visitIndexWithInt:[arrayCtx getCurrentIndex] withElementalJsonImplJsonContext:arrayCtx]) {
        [visitor acceptWithGDJsonValue:[self getWithInt:i] withElementalJsonImplJsonContext:arrayCtx];
        [arrayCtx setFirstWithBoolean:NO];
      }
    }
  }
  [visitor endVisitWithGDJsonArray:self withElementalJsonImplJsonContext:ctx];
}

- (void)insert:(int)index value:(id<GDJsonValue>)value {
  if (value == nil) {
    value = [((id<GDJsonFactory>) nil_chk(factory_)) createNull];
  }
  [((JavaUtilArrayList *) nil_chk(arrayValues_)) addWithInt:index withId:value];
}

- (void)copyAllFieldsTo:(ElementalJsonImplJreJsonArray *)other {
  [super copyAllFieldsTo:other];
  other->arrayValues_ = arrayValues_;
  other->factory_ = factory_;
}

@end
