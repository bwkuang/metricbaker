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

runTests(){
    java -cp $CLASSPATH org.junit.runner.JUnitCore metricbaker.IngredientConverterTest
    java -cp $CLASSPATH org.junit.runner.JUnitCore metricbaker.AcceptanceTest
}

##########################

setPathToProjectRoot;
setPathsToBinaries;
setClassPath;
runTests;