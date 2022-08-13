set PATH_TO_FX="C:\JavaSA\javafx-sdk-18.0.1\lib"
rem %PATH_TO_FX%
rem javac -d out --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\ --add-modules javafx.controls,javafx.fxml  src\*.java
javac -d out --all-module-path C:\JavaSA\javafx-sdk-18.0.1\lib\  src\*.java
  