rem javac -classpath ./classes;C:\JavaSA\javafx-sdk-18.0.1\lib\  -d classes src\HelloApplication.java
rem --module-path "C:\JavaSA\javafx-sdk-18.0.1\lib\\"
rem javac --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\ --add-modules javafx.controls,javafx.fxml    -d classes src\HelloApplication.java
javac -d out --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\ --add-modules javafx.controls,javafx.fxml   src\*.java
