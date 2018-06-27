DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";

mkdir -p $DIR/tmp/;
mkdir -p $DIR/build/classes/main/;
mkdir -p $DIR/build/classes/test/;

FOLDER_MAIN_CLASSES=$DIR/build/classes/main/
FOLDER_TEST_CLASSES=$DIR/build/classes/test/

CLASSPATH_JAR=$(echo $DIR/libs/*.jar | tr ' ' ':');
CLASSPATH_MAIN=$FOLDER_MAIN_CLASSES:$CLASSPATH_JAR;
CLASSPATH_TEST=$FOLDER_MAIN_CLASSES:$CLASSPATH_JAR:$FOLDER_TEST_CLASSES;

# Compile main application
javac -d $FOLDER_MAIN_CLASSES -cp $CLASSPATH_MAIN $DIR/src/main/java/*.java;

# Compile tests
javac -d $FOLDER_TEST_CLASSES -cp $CLASSPATH_TEST -Xlint:deprecation $DIR/src/test/java/*.java;
