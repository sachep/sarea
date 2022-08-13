rem javac -classpath ./classes;C:\JavaSA\javafx-sdk-18.0.1\lib\  -d classes src\HelloApplication.java
rem --module-path "C:\JavaSA\javafx-sdk-18.0.1\lib\\"
rem javac --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\ --add-modules javafx.controls,javafx.fxml    -d classes src\HelloApplication.java
java --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\  --module javafx.base,javafx.controls,javafx.fxml out\HelloApplication
rem java  -cp C:\JavaSA\javafx-sdk-18.0.1\lib\ --add-modules javafx.controls,javafx.fxml -classpath \out  .out\HelloApplication
rem java  -cp C:\JavaSA\javafx-sdk-18.0.1\lib\  .out\HelloAppli
