//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//
//  Created by Larry Tin <dev@goodow.com>
//

#ifndef _ElementalJsonImplJreJsonObject_H_
#define _ElementalJsonImplJreJsonObject_H_

@class ElementalJsonImplJsonContext;
@class ElementalJsonImplJsonVisitor;
@class GDJsonTypeEnum;
@class IOSObjectArray;
@protocol GDJsonArray;
@protocol GDJsonFactory;
@protocol GDJsonValue;
@protocol JavaUtilList;
@protocol JavaUtilMap;

#import "JreEmulation.h"
#include "elemental/json/JsonObject.h"
#include "elemental/json/impl/JreJsonValue.h"

@interface ElementalJsonImplJreJsonObject : ElementalJsonImplJreJsonValue < GDJsonObject > {
 @public
  id<GDJsonFactory> factory_;
  id<JavaUtilMap> map_;
}

+ (id<JavaUtilList>)stringifyOrderWithNSStringArray:(IOSObjectArray *)keys;
- (id)initWithGDJsonFactory:(id<GDJsonFactory>)factory;
- (BOOL)asBoolean;
- (double)asNumber;
- (NSString *)asString;
- (id<GDJsonValue>)getWithNSString:(NSString *)key;
- (id<GDJsonArray>)getArray:(NSString *)key;
- (BOOL)getBoolean:(NSString *)key;
- (double)getNumber:(NSString *)key;
- (id<GDJsonObject>)getObject:(NSString *)key;
- (id)getObject;
- (NSString *)getString:(NSString *)key;
- (GDJsonTypeEnum *)getType;
- (BOOL)hasKey:(NSString *)key;
- (BOOL)jsEquals:(id<GDJsonValue>)value;
- (IOSObjectArray *)keys;
- (void)set:(NSString *)key value:(id<GDJsonValue>)value;
- (void)set:(NSString *)key string:(NSString *)value;
- (void)set:(NSString *)key number:(double)value;
- (void)set:(NSString *)key boolean:(BOOL)bool_;
- (void)remove:(NSString *)key;
- (void)setWithNSString:(NSString *)key
        withGDJsonValue:(id<GDJsonValue>)value;
- (NSString *)toJson;
- (NSString *)description;
- (void)traverseWithElementalJsonImplJsonVisitor:(ElementalJsonImplJsonVisitor *)visitor
                withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (void)copyAllFieldsTo:(ElementalJsonImplJreJsonObject *)other;
@end

J2OBJC_FIELD_SETTER(ElementalJsonImplJreJsonObject, factory_, id<GDJsonFactory>)
J2OBJC_FIELD_SETTER(ElementalJsonImplJreJsonObject, map_, id<JavaUtilMap>)

#endif // _ElementalJsonImplJreJsonObject_H_
