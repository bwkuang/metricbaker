DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";
CLASSPATH_JAR=$(echo lib/*.jar | tr ' ' ':');
CLASSPATH_MAIN=$DIR/src/main/java:$CLASSPATH_JAR;
CLASSPATH_TEST=$DIR/src/main/java:$DIR/src/test/java:$CLASSPATH_JAR;


# Compile main application
javac -cp $CLASSPATH_MAIN $DIR/src/main/java/*.java;

# Compile tests
javac -cp $CLASSPATH_TEST -Xlint:deprecation $DIR/src/test/java/*.java;
