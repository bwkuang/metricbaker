DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";
CLASSPATH_JAR=$(echo lib/*.jar | tr ' ' ':');
CLASSPATH=$DIR/src/test/java/:$DIR/src/main/java:$CLASSPATH_JAR;

java -cp $CLASSPATH org.junit.runner.JUnitCore IngredientConverterTest
java -cp $CLASSPATH org.junit.runner.JUnitCore AcceptanceTest
