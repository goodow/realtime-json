//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//
//  Created by Larry Tin <dev@goodow.com>
//

#ifndef _ElementalJsonImplJsonVisitor_H_
#define _ElementalJsonImplJsonVisitor_H_

@protocol GDJsonArray;
@protocol GDJsonObject;
@protocol GDJsonValue;

#import "JreEmulation.h"
#include "elemental/json/impl/JsonContext.h"

@interface ElementalJsonImplJsonVisitor : NSObject {
}

- (void)acceptWithGDJsonValue:(id<GDJsonValue>)node;
- (void)acceptWithGDJsonValue:(id<GDJsonValue>)node
withElementalJsonImplJsonContext:(ElementalJsonImplJsonContext *)ctx;
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
- (id)init;
@end

@interface ElementalJsonImplJsonVisitor_ImmutableJsonContext : ElementalJsonImplJsonContext {
}

- (id)initWithElementalJsonImplJsonVisitor:(ElementalJsonImplJsonVisitor *)outer$
                           withGDJsonValue:(id<GDJsonValue>)node;
- (void)removeMe;
- (void)replaceMeWithDouble:(double)d;
- (void)replaceMeWithNSString:(NSString *)d;
- (void)replaceMeWithBoolean:(BOOL)d;
- (void)replaceMeWithGDJsonValue:(id<GDJsonValue>)value;
- (void)immutableError;
@end

#endif // _ElementalJsonImplJsonVisitor_H_
