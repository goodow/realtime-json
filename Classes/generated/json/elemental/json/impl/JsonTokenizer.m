//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//
//  Created by Larry Tin <dev@goodow.com>
//

#include "IOSCharArray.h"
#include "IOSClass.h"
#include "elemental/json/JsonArray.h"
#include "elemental/json/JsonBoolean.h"
#include "elemental/json/JsonException.h"
#include "elemental/json/JsonFactory.h"
#include "elemental/json/JsonNull.h"
#include "elemental/json/JsonNumber.h"
#include "elemental/json/JsonObject.h"
#include "elemental/json/JsonString.h"
#include "elemental/json/JsonValue.h"
#include "elemental/json/impl/JreJsonFactory.h"
#include "elemental/json/impl/JsonTokenizer.h"
#include "java/lang/Character.h"
#include "java/lang/Double.h"
#include "java/lang/Integer.h"
#include "java/lang/Math.h"
#include "java/lang/NumberFormatException.h"
#include "java/lang/StringBuffer.h"
#include "java/lang/System.h"

@implementation ElementalJsonImplJsonTokenizer

static NSString * ElementalJsonImplJsonTokenizer_STOPCHARS_ = @",:]}/\\\"[{;=#";

+ (NSString *)STOPCHARS {
  return ElementalJsonImplJsonTokenizer_STOPCHARS_;
}

- (id)initWithElementalJsonImplJreJsonFactory:(ElementalJsonImplJreJsonFactory *)serverJsonFactory
                                 withNSString:(NSString *)json {
  if (self = [super init]) {
    lenient_ = YES;
    pushBackBuffer_ = ElementalJsonImplJsonTokenizer_INVALID_CHAR;
    position_ = 0;
    self->jsonFactory_ = serverJsonFactory;
    self->json_ = json;
  }
  return self;
}

- (void)backWithChar:(unichar)c {
  NSAssert(pushBackBuffer_ == ElementalJsonImplJsonTokenizer_INVALID_CHAR, @"src/elemental/json/impl/JsonTokenizer.java:50 condition failed: assert pushBackBuffer == INVALID_CHAR;");
  pushBackBuffer_ = c;
}

- (void)backWithInt:(int)c {
  [self backWithChar:(unichar) c];
}

- (int)next {
  if (pushBackBuffer_ != ElementalJsonImplJsonTokenizer_INVALID_CHAR) {
    int c = pushBackBuffer_;
    pushBackBuffer_ = ElementalJsonImplJsonTokenizer_INVALID_CHAR;
    return c;
  }
  return position_ < [((NSString *) nil_chk(json_)) length] ? [json_ charAtWithInt:position_++] : ElementalJsonImplJsonTokenizer_INVALID_CHAR;
}

- (NSString *)nextWithInt:(int)n {
  if (n == 0) {
    return @"";
  }
  IOSCharArray *buffer = [IOSCharArray arrayWithLength:n];
  int pos = 0;
  if (pushBackBuffer_ != ElementalJsonImplJsonTokenizer_INVALID_CHAR) {
    (*IOSCharArray_GetRef(buffer, 0)) = (unichar) pushBackBuffer_;
    pos = 1;
    pushBackBuffer_ = ElementalJsonImplJsonTokenizer_INVALID_CHAR;
  }
  int len;
  while ((pos < n) && ((len = [self readWithCharArray:buffer withInt:pos withInt:n - pos]) != -1)) {
    pos += len;
  }
  if (pos < n) {
    @throw [[GDJsonException alloc] initWithNSString:@"TODO"];
  }
  return [NSString valueOfChars:buffer];
}

+ (IOSObjectArray *)__exceptions_nextWithInt_ {
  return [IOSObjectArray arrayWithObjects:(id[]) { [GDJsonException getClass] } count:1 type:[IOSClass getClass]];
}

- (int)nextNonWhitespace {
  while (YES) {
    int c = [self next];
    if (![JavaLangCharacter isSpaceWithChar:(unichar) c]) {
      return c;
    }
  }
}

- (NSString *)nextStringWithInt:(int)startChar {
  JavaLangStringBuffer *buffer = [[JavaLangStringBuffer alloc] init];
  int c = [self next];
  NSAssert(c == ElementalJsonImplJsonTokenizer_DOUBLE_QUOTE || (lenient_ && c == ElementalJsonImplJsonTokenizer_SINGLE_QUOTE), @"src/elemental/json/impl/JsonTokenizer.java:109 condition failed: assert c == DOUBLE_QUOTE || (lenient && c == SINGLE_QUOTE);");
  while (YES) {
    c = [self next];
    switch (c) {
      case 0x000d:
      case 0x000a:
      @throw [[GDJsonException alloc] initWithNSString:@""];
      case '\\':
      c = [self next];
      switch (c) {
        case 'b':
        (void) [buffer appendWithChar:0x0008];
        break;
        case 't':
        (void) [buffer appendWithChar:0x0009];
        break;
        case 'n':
        (void) [buffer appendWithChar:0x000a];
        break;
        case 'f':
        (void) [buffer appendWithChar:0x000c];
        break;
        case 'r':
        (void) [buffer appendWithChar:0x000d];
        break;
        case 'u':
        (void) [buffer appendWithChar:(unichar) [JavaLangInteger parseIntWithNSString:[self nextWithInt:4] withInt:16]];
        break;
        default:
        (void) [buffer appendWithChar:(unichar) c];
      }
      break;
      default:
      if (c == startChar) {
        return [buffer description];
      }
      (void) [buffer appendWithChar:(unichar) c];
    }
  }
}

+ (IOSObjectArray *)__exceptions_nextStringWithInt_ {
  return [IOSObjectArray arrayWithObjects:(id[]) { [GDJsonException getClass] } count:1 type:[IOSClass getClass]];
}

- (NSString *)nextUntilOneOfWithNSString:(NSString *)chars {
  JavaLangStringBuffer *buffer = [[JavaLangStringBuffer alloc] init];
  int c = [self next];
  while (c != ElementalJsonImplJsonTokenizer_INVALID_CHAR) {
    if ([JavaLangCharacter isSpaceWithChar:(unichar) c] || [((NSString *) nil_chk(chars)) indexOf:(unichar) c] >= 0) {
      [self backWithInt:c];
      break;
    }
    (void) [buffer appendWithChar:(unichar) c];
    c = [self next];
  }
  return [buffer description];
}

- (id)nextValue {
  int c = [self nextNonWhitespace];
  [self backWithInt:c];
  switch (c) {
    case '"':
    case '\'':
    return (id<GDJsonValue>) [((id<GDJsonFactory>) nil_chk(jsonFactory_)) createWithNSString:[self nextStringWithInt:c]];
    case '{':
    return (id<GDJsonValue>) [self parseObject];
    case '[':
    return (id<GDJsonValue>) [self parseArray];
    default:
    return (id<GDJsonValue>) [self getValueForLiteralWithNSString:[self nextUntilOneOfWithNSString:ElementalJsonImplJsonTokenizer_STOPCHARS_]];
  }
}

+ (IOSObjectArray *)__exceptions_nextValue {
  return [IOSObjectArray arrayWithObjects:(id[]) { [GDJsonException getClass] } count:1 type:[IOSClass getClass]];
}

- (id<GDJsonArray>)parseArray {
  id<GDJsonArray> array = [((id<GDJsonFactory>) nil_chk(jsonFactory_)) createArray];
  int c = [self nextNonWhitespace];
  NSAssert(c == '[', @"src/elemental/json/impl/JsonTokenizer.java:185 condition failed: assert c == '[';");
  while (YES) {
    c = [self nextNonWhitespace];
    {
      int d;
      switch (c) {
        case ']':
        return array;
        default:
        [self backWithInt:c];
        [array set:[((id<GDJsonArray>) nil_chk(array)) length] value:[self nextValue]];
        d = [self nextNonWhitespace];
        switch (d) {
          case ']':
          return array;
          case ',':
          break;
          default:
          @throw [[GDJsonException alloc] initWithNSString:@"Invalid array: expected , or ]"];
        }
      }
    }
  }
}

+ (IOSObjectArray *)__exceptions_parseArray {
  return [IOSObjectArray arrayWithObjects:(id[]) { [GDJsonException getClass] } count:1 type:[IOSClass getClass]];
}

- (id<GDJsonObject>)parseObject {
  id<GDJsonObject> object = [((id<GDJsonFactory>) nil_chk(jsonFactory_)) createObject];
  int c = [self nextNonWhitespace];
  if (c != '{') {
    @throw [[GDJsonException alloc] initWithNSString:[NSString stringWithFormat:@"Payload does not begin with '{'.  Got %d(%@)", c, [JavaLangCharacter valueOfWithChar:(unichar) c]]];
  }
  while (YES) {
    c = [self nextNonWhitespace];
    {
      NSString *key;
      switch (c) {
        case '}':
        return object;
        case '"':
        case '\'':
        [self backWithInt:c];
        key = [self nextStringWithInt:c];
        if ([self nextNonWhitespace] != ':') {
          @throw [[GDJsonException alloc] initWithNSString:@"Invalid object: expecting \":\""];
        }
        [((id<GDJsonObject>) nil_chk(object)) set:key value:[self nextValue]];
        switch ([self nextNonWhitespace]) {
          case ',':
          break;
          case '}':
          return object;
          default:
          @throw [[GDJsonException alloc] initWithNSString:@"Invalid object: expecting } or ,"];
        }
        break;
        case ',':
        break;
        default:
        if (lenient_ && ([JavaLangCharacter isDigitWithChar:(unichar) c] || [JavaLangCharacter isLetterOrDigitWithChar:(unichar) c])) {
          JavaLangStringBuffer *keyBuffer = [[JavaLangStringBuffer alloc] init];
          (void) [keyBuffer appendWithInt:c];
          while (YES) {
            c = [self next];
            if ([JavaLangCharacter isDigitWithChar:(unichar) c] || [JavaLangCharacter isLetterOrDigitWithChar:(unichar) c]) {
              (void) [keyBuffer appendWithInt:c];
            }
            else {
              [self backWithInt:c];
              break;
            }
          }
          if ([self nextNonWhitespace] != ':') {
            @throw [[GDJsonException alloc] initWithNSString:@"Invalid object: expecting \":\""];
          }
          [((id<GDJsonObject>) nil_chk(object)) set:[keyBuffer description] value:[self nextValue]];
          switch ([self nextNonWhitespace]) {
            case ',':
            break;
            case '}':
            return object;
            default:
            @throw [[GDJsonException alloc] initWithNSString:@"Invalid object: expecting } or ,"];
          }
        }
        else {
          @throw [[GDJsonException alloc] initWithNSString:@"Invalid object: "];
        }
      }
    }
  }
}

+ (IOSObjectArray *)__exceptions_parseObject {
  return [IOSObjectArray arrayWithObjects:(id[]) { [GDJsonException getClass] } count:1 type:[IOSClass getClass]];
}

- (id<GDJsonNumber>)getNumberForLiteralWithNSString:(NSString *)literal {
  @try {
    return [((id<GDJsonFactory>) nil_chk(jsonFactory_)) createWithDouble:[JavaLangDouble parseDoubleWithNSString:literal]];
  }
  @catch (JavaLangNumberFormatException *e) {
    @throw [[GDJsonException alloc] initWithNSString:[NSString stringWithFormat:@"Invalid number literal: %@", literal]];
  }
}

+ (IOSObjectArray *)__exceptions_getNumberForLiteralWithNSString_ {
  return [IOSObjectArray arrayWithObjects:(id[]) { [GDJsonException getClass] } count:1 type:[IOSClass getClass]];
}

- (id<GDJsonValue>)getValueForLiteralWithNSString:(NSString *)literal {
  if ([@"" isEqual:literal]) {
    @throw [[GDJsonException alloc] initWithNSString:@"Missing value"];
  }
  if ([@"null" isEqual:literal] || [@"undefined" isEqual:literal]) {
    return [((id<GDJsonFactory>) nil_chk(jsonFactory_)) createNull];
  }
  if ([@"true" isEqual:literal]) {
    return [((id<GDJsonFactory>) nil_chk(jsonFactory_)) createWithBoolean:YES];
  }
  if ([@"false" isEqual:literal]) {
    return [((id<GDJsonFactory>) nil_chk(jsonFactory_)) createWithBoolean:NO];
  }
  unichar c = [((NSString *) nil_chk(literal)) charAtWithInt:0];
  if (c == '-' || [JavaLangCharacter isDigitWithChar:c]) {
    return [self getNumberForLiteralWithNSString:literal];
  }
  @throw [[GDJsonException alloc] initWithNSString:[NSString stringWithFormat:@"Invalid literal: \"%@\"", literal]];
}

+ (IOSObjectArray *)__exceptions_getValueForLiteralWithNSString_ {
  return [IOSObjectArray arrayWithObjects:(id[]) { [GDJsonException getClass] } count:1 type:[IOSClass getClass]];
}

- (int)readWithCharArray:(IOSCharArray *)buffer
                 withInt:(int)pos
                 withInt:(int)len {
  int maxLen = [JavaLangMath minWithInt:[((NSString *) nil_chk(json_)) length] - position_ withInt:len];
  NSString *src = [json_ substring:position_ endIndex:position_ + maxLen];
  IOSCharArray *result = [((NSString *) nil_chk(src)) toCharArray];
  [JavaLangSystem arraycopyWithId:result withInt:0 withId:buffer withInt:pos withInt:maxLen];
  position_ += maxLen;
  return maxLen;
}

- (void)copyAllFieldsTo:(ElementalJsonImplJsonTokenizer *)other {
  [super copyAllFieldsTo:other];
  other->json_ = json_;
  other->jsonFactory_ = jsonFactory_;
  other->lenient_ = lenient_;
  other->position_ = position_;
  other->pushBackBuffer_ = pushBackBuffer_;
}

@end
