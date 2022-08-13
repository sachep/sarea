rem set PATH_TO_FX="C:\JavaSA\javafx-sdk-18.0.1\lib"
rem %PATH_TO_FX%
rem javac --module-path %PATH_TO_FX% --add-modules java.controls.java JavaFXEventDemo.java
rem
rem компиляция  программы с библиотекой
rem javac -encoding UTF-8 -sourcepath src -d bin -classpath lib/calculator.jar src/gmail/sa/ds/ds.java
rem запуск программы с библиотекой
rem java  -classpath bin: lib/calculator.jar gmail.sa.ds.ds
java -classpath bin:lib/calculator.jar gmail.sa.ds.ds 


  