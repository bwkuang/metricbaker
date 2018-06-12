DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";

mkdir -p $DIR/tmp/;
mkdir -p $DIR/build/classes/main/;
mkdir -p $DIR/build/classes/test/;

FOLDER_MAIN_CLASSES=$DIR/build/classes/main/
FOLDER_TEST_CLASSES=$DIR/build/classes/test/

CLASSPATH_JAR=$(echo libs/*.jar | tr ' ' ':');
CLASSPATH=$FOLDER_MAIN_CLASSES:$CLASSPATH_JAR:$FOLDER_TEST_CLASSES;

java -cp $CLASSPATH org.junit.runner.JUnitCore IngredientConverterTest
java -cp $CLASSPATH org.junit.runner.JUnitCore AcceptanceTest
