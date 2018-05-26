DIR=~/Documents/metricBaker;
CLASSPATH=$DIR/lib/*:$DIR/src/test/java/:$DIR/src/main/java

java -cp $CLASSPATH org.junit.runner.JUnitCore IngredientConverterTest
java -cp $CLASSPATH org.junit.runner.JUnitCore AcceptanceTest
