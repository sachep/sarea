rem сначала функции
rem javac -d appmodules\appfuncs appsrc\appfuncs\appfuncs\simplefuncs\SimpleMathFuncs.java
rem далее модуль module-info.java
rem javac -d appmodules\appfuncs appsrc\appfuncs\module-info.java
rem а можно сразу и то и то
rem javac -d appmodules\appfuncs appsrc\appfuncs\appfuncs\simplefuncs\SimpleMathFuncs.java appsrc\appfuncs\module-info.java
rem компилируем модули и файл запускаемый т.н.  старт
rem javac --module-path appmodules -d appmodules\appstart appsrc\appstart\appstart\mymodappdemo\MyModAppDemo.java appsrc\appstart\module-info.java
rem либо компилировать все сразу
rem javac --module-source-path appsrc -d appmodules appsrc\appstart\appstart\mymodappdemo\MyModAppDemo.java 



