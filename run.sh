DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";
CLASSPATH=$DIR/lib/*:$DIR/src/test/java/:$DIR/src/main/java

java -cp $CLASSPATH org.junit.runner.JUnitCore IngredientConverterTest
java -cp $CLASSPATH org.junit.runner.JUnitCore AcceptanceTest
