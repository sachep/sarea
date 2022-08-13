rem компилировать все сразу для варианта со службами и провайдерами
rem  
rem javac -d appmodules --module-source-path appsrc appsrc\userfuncs\module-info.java appsrc\userfuncsimp\module-info.java   appsrc\appstart\appstart\mymodappdemo\MyModAppDemo.java
rem СА : вобщем компилируется все  что зависит от запускаемого - здесь все скомпилируется
javac -d appmodules --module-source-path appsrc appsrc\appstart\module-info.java appsrc\userfuncsimp\module-info.java   appsrc\appstart\appstart\mymodappdemo\MyModAppDemo.java
