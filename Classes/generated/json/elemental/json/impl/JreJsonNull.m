//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//
//  Created by Larry Tin <dev@goodow.com>
//

#include "elemental/json/JsonNull.h"
#include "elemental/json/JsonType.h"
#include "elemental/json/JsonValue.h"
#include "elemental/json/impl/JreJsonNull.h"
#include "elemental/json/impl/JsonContext.h"
#include "elemental/json/impl/JsonVisitor.h"

@implementation ElementalJsonImplJreJsonNull

static id<GDJsonNull> ElementalJsonImplJreJsonNull_NULL_INSTANCE_;

+ (id<GDJsonNull>)NULL_INSTANCE {
  return ElementalJsonImplJreJsonNull_NULL_INSTANCE_;
}

- (double)asNumber {
  return 0;
}

- (BOOL)asBoolean {
  return NO;
}

- (NSString *)asString {
  return @"null";
}

- (id)getObject {
  return nil;
}

- (GDJsonTypeEnum *)getType {
  return [GDJsonTypeEnum NULL_];
}

- (BOOL)jsEquals:(id<GDJsonValue>)value {
  return value == nil || [value getType] == [GDJsonTypeEnum NULL_];
}

- (void)traverseWithElementalJsonImplJsonVisitor:(ElementalJsonImplJsonVisitor *)visitor
                withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx {
  [((ElementalJsonImplJsonVisitor *) nil_chk(visitor)) visitNullWithElementalJsonImplJsonContext:ctx];
}

- (NSString *)toJson {
  return [self asString];
}

- (id)init {
  return [super init];
}

+ (void)initialize {
  if (self == [ElementalJsonImplJreJsonNull class]) {
    ElementalJsonImplJreJsonNull_NULL_INSTANCE_ = [[ElementalJsonImplJreJsonNull alloc] init];
  }
}

@end