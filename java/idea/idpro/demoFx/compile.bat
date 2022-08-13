rem javac -d target --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\;target --module-source-path src src\main\java\module-info.java  src\main\java\com\example\demofx\HelloApplication.java 
REM javac -d target2 --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\;target2   src\main\java\module-info.java  
rem javac -d target2 --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\   --module-source-path src\main src\main\java\com\example\d0emofx\HelloApplication.java  
javac -d target2 --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\ --add-modules javafx.controls,javafx.fxml  src\main\java\com\example\demofx\*.java src\main\java\module-info.java

