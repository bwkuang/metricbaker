DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )";

mkdir -p $DIR/tmp/;
mkdir -p $DIR/build/classes/main/java;
mkdir -p $DIR/build/classes/test/java;

FOLDER_MAIN_CLASS_ROOT=$DIR/build/classes/main/java;
FOLDER_TEST_CLASS_ROOT=$DIR/build/classes/test/java;

CLASSPATH_JAR=$(echo $DIR/libs/*.jar | tr ' ' ':');
CLASSPATH_MAIN=$FOLDER_MAIN_CLASS_ROOT:$CLASSPATH_JAR;
CLASSPATH_TEST=$FOLDER_MAIN_CLASS_ROOT:$CLASSPATH_JAR:$FOLDER_TEST_CLASS_ROOT;

# Compile main application
javac -d $FOLDER_MAIN_CLASS_ROOT -cp $CLASSPATH_MAIN $DIR/src/main/java/metricbaker/*.java;

# Compile tests
javac -d $FOLDER_TEST_CLASS_ROOT -cp $CLASSPATH_TEST -Xlint:deprecation $DIR/src/test/java/metricbaker/*.java;