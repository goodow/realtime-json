//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//
//  Created by Larry Tin <dev@goodow.com>
//

#ifndef _ElementalJsonImplJsonUtil_H_
#define _ElementalJsonImplJsonUtil_H_

@class ElementalJsonImplJsonContext;
@class JavaLangStringBuffer;
@protocol GDJsonArray;
@protocol GDJsonObject;
@protocol GDJsonValue;
@protocol JavaUtilSet;

#import "JreEmulation.h"
#include "elemental/json/impl/JsonVisitor.h"

@interface ElementalJsonImplJsonUtil : NSObject {
}

+ (NSString *)escapeControlCharsWithNSString:(NSString *)text;
+ (id)parseWithNSString:(NSString *)json;
+ (NSString *)quoteWithNSString:(NSString *)value;
+ (NSString *)stringifyWithGDJsonValue:(id<GDJsonValue>)jsonValue;
+ (NSString *)stringifyWithGDJsonValue:(id<GDJsonValue>)jsonValue
                               withInt:(int)spaces;
+ (NSString *)stringifyWithGDJsonValue:(id<GDJsonValue>)jsonValue
                          withNSString:(NSString *)indent;
+ (NSString *)escapeStringAsUnicodeWithNSString:(NSString *)match;
+ (BOOL)isControlCharWithChar:(unichar)c;
- (id)init;
@end

@protocol ElementalJsonImplJsonUtil_RegExpReplacer < NSObject, JavaObject >
- (NSString *)replaceWithNSString:(NSString *)match;
@end

@interface ElementalJsonImplJsonUtil_StringifyJsonVisitor : ElementalJsonImplJsonVisitor {
 @public
  NSString *indentLevel_;
  id<JavaUtilSet> visited_;
  NSString *indent_;
  JavaLangStringBuffer *sb_;
  BOOL pretty_;
}

+ (id<JavaUtilSet>)skipKeys;
- (id)initWithNSString:(NSString *)indent
withJavaLangStringBuffer:(JavaLangStringBuffer *)sb
           withBoolean:(BOOL)pretty;
- (void)endVisitWithGDJsonArray:(id<GDJsonArray>)array
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (void)endVisitWithGDJsonObject:(id<GDJsonObject>)object
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (void)visitWithDouble:(double)number
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (void)visitWithNSString:(NSString *)string
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (void)visitWithBoolean:(BOOL)bool_
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (BOOL)visitWithGDJsonArray:(id<GDJsonArray>)array
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (BOOL)visitWithGDJsonObject:(id<GDJsonObject>)object
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (BOOL)visitIndexWithInt:(int)index
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (BOOL)visitKeyWithNSString:(NSString *)key
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (void)visitNullWithElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (void)checkCycleWithGDJsonValue:(id<GDJsonValue>)value;
- (void)commaIfNotFirstWithElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
- (NSString *)formatWithDouble:(double)number;
- (void)copyAllFieldsTo:(ElementalJsonImplJsonUtil_StringifyJsonVisitor *)other;
@end

J2OBJC_FIELD_SETTER(ElementalJsonImplJsonUtil_StringifyJsonVisitor, indentLevel_, NSString *)
J2OBJC_FIELD_SETTER(ElementalJsonImplJsonUtil_StringifyJsonVisitor, visited_, id<JavaUtilSet>)
J2OBJC_FIELD_SETTER(ElementalJsonImplJsonUtil_StringifyJsonVisitor, indent_, NSString *)
J2OBJC_FIELD_SETTER(ElementalJsonImplJsonUtil_StringifyJsonVisitor, sb_, JavaLangStringBuffer *)

#endif // _ElementalJsonImplJsonUtil_H_
