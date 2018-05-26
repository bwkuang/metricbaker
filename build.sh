DIR=~/Documents/metricBaker;
CLASSPATH_MAIN=$DIR/src/main/java:$DIR/lib/*;
CLASSPATH_TEST=$DIR/src/main/java:$DIR/lib/*:$DIR/src/test/java;

# Compile main application
javac -cp $CLASSPATH_MAIN $DIR/src/main/java/IngredientConverter.java $DIR/src/main/java/BreadIngredientsConverter.java;

# Compile tests
javac -cp $CLASSPATH_TEST -Xlint:deprecation $DIR/src/test/java/IngredientConverterTest.java $DIR/src/test/java/AcceptanceTest.java;
