rem set PATH_TO_FX="C:\JavaSA\javafx-sdk-18.0.1\lib"
rem %PATH_TO_FX%
rem javac --module-path %PATH_TO_FX% --add-modules java.controls.java JavaFXEventDemo.java
rem
rem компиляция  калькулятор в отдельном каталогев
rem javac -encoding UTF-8 -sourcepath ./src -d out src\gmail\sa\calc\Calculator.java
rem делаем архив проекта калькулятора
jar cvf calculator.jar -C out .


  