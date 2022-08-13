rem СА : вобщем компилируется все  что зависит от запускаемого - 
rem здесь только пользовательские функции
rem сначала функции
rem javac -d appmodules\userfuncs appsrc\userfuncs\userfuncs\binaryfuncs\BinaryFunc.java
rem далее модуль module-info.java
rem javac -d appmodules\userfuncs appsrc\userfuncs\module-info.java
rem а можно сразу и то и то
rem javac -d appmodules\appfuncs appsrc\appfuncs\appfuncs\simplefuncs\SimpleMathFuncs.java appsrc\appfuncs\module-info.java
javac --module-source-path appsrc -d appmodules appsrc\userfuncsimp\userfuncsimp\binaryfuncsimp\AbsPlus.java 
rem javac -d appmodules\userfuncsimp appsrc\userfuncsimp\userfuncsimp\binaryfuncsimp\AbsMinus.java 
rem appsrc\userfuncsimp\module-info.java

