rem set PATH_TO_FX="C:\JavaSA\javafx-sdk-18.0.1\lib"
rem %PATH_TO_FX%
rem javac --module-path %PATH_TO_FX% --add-modules java.controls.java JavaFXEventDemo.java
rem
rem компиляция отдельных файлов-классов
javac -encoding UTF-8 -sourcepath ./src -d out src\gmail\sa\ds\ds.java
rem запуск
java -classpath ./out gmail.sa.ds.ds
rem
rem javac -encoding UTF-8 -sourcepath ./src -d out src\gmail\sa\ds\ds.java
rem  java -classpath ./out gmail.sa.ds.ds


  