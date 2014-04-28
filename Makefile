.SUFFIXES: .java .m
.PHONY: default clean translate link

include ../resources/make/common.mk
# J2OBJC_DIST = GDJson/Project/Pods/J2ObjC/dist

JSON_GEN_DIR = GDJson/Classes/generated
MAIN_SOURCES = $(subst $(MAIN_SRC_DIR)/,,$(shell find $(MAIN_SRC_DIR)/com/goodow/realtime/json -maxdepth 1 -name *.java))
MAIN_GEN_SOURCES = $(MAIN_SOURCES:%.java=$(JSON_GEN_DIR)/%.m)
OVERRIDE_GEN_DIR = GDJson/Classes/override
MAIN_OBJECTS = $(MAIN_SOURCES:%.java=$(BUILD_DIR)/main/%.o)
SUPPORT_LIB = $(BUILD_DIR)/libGDJson.a

default: clean translate

translate: translate_main

pre_translate_main: $(BUILD_DIR) $(JSON_GEN_DIR)
	@rm -f $(MAIN_SOURCE_LIST)
	@touch $(MAIN_SOURCE_LIST)
        
$(JSON_GEN_DIR)/%.m $(JSON_GEN_DIR)/%.h: $(MAIN_SRC_DIR)/%.java
	@echo $? >> $(MAIN_SOURCE_LIST)

translate_main: pre_translate_main $(MAIN_GEN_SOURCES)
	@if [ `cat $(MAIN_SOURCE_LIST) | wc -l` -ge 1 ] ; then \
	  $(J2OBJC) -sourcepath $(MAIN_SRC_DIR) -d $(JSON_GEN_DIR) \
	    `cat $(MAIN_SOURCE_LIST)` ; \
	fi
	cp -r $(OVERRIDE_GEN_DIR)/ $(JSON_GEN_DIR)

$(BUILD_DIR)/main/%.o: $(JSON_GEN_DIR)/%.m $(MAIN_SRC_DIR)/%.java
	@mkdir -p `dirname $@`
	@$(J2OBJCC) -c $< -o $@ -g -I$(JSON_GEN_DIR)

$(SUPPORT_LIB): $(MAIN_OBJECTS)
	libtool -static -o $(SUPPORT_LIB) $(MAIN_OBJECTS) $(SUPPORT_LIB)

link: translate $(SUPPORT_LIB)

$(JSON_GEN_DIR):
	@mkdir -p $(JSON_GEN_DIR)
$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)/main

clean:
	@rm -rf $(JSON_GEN_DIR) $(BUILD_DIR)
