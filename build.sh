ROOTPATH="";
MAIN_CLASSPATH="";
TEST_CLASSPATH="";
JARPATH="";

setPathToProjectRoot() {
    ROOTPATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";
}

setPathsToBinaries() {
    MAIN_CLASSPATH=$ROOTPATH/build/classes/main/java;
    TEST_CLASSPATH=$ROOTPATH/build/classes/test/java;
    JARPATH=$(echo $ROOTPATH/libs/*.jar | tr ' ' ':');
}

setClassPath() {
    CLASSPATH=$MAIN_CLASSPATH:$JARPATH:$TEST_CLASSPATH;
}

createBinaryFolderStructure() {
    mkdir -p $ROOTPATH/tmp;
    mkdir -p $MAIN_CLASSPATH;
    mkdir -p $TEST_CLASSPATH;
}

compileMainApplication() {
    javac -d $MAIN_CLASSPATH -cp $CLASSPATH $ROOTPATH/src/main/java/metricbaker/*.java;
}

compileTests() {
    javac -d $TEST_CLASSPATH -cp $CLASSPATH -Xlint:deprecation $ROOTPATH/src/test/java/metricbaker/*.java;
}

##########################

setPathToProjectRoot;
setPathsToBinaries;
setClassPath;
createBinaryFolderStructure;
compileMainApplication;
compileTests;