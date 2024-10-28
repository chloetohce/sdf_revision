SRC_DIR = src
OUT_DIR = classes
JARFILE = revision.jar

SOURCES = $(shell find $(SRC_DIR) -name '*.java')
JAVAC = javac
JAVA = java
JFLAGS = -d $(OUT_DIR) -cp $(OUT_DIR)

APP = App

compile: $(SOURCES)
	$(JAVAC) ${SOURCES} ${JFLAGS}

run:
	$(JAVA) -cp ${OUT_DIR} ${APP}

jar: compile
	jar cvf ${JARFILE} -C ${OUT_DIR} .

run-jar:
	java -cp ${JARFILE} ${APP}

clean:
	@rm -rf ${JARFILE}
	@rm -rf ${OUT_DIR}