rem �� : ������ ������������� ���  ��� ������� �� ������������ - 
rem ����� ������ ���������������� �������
rem ������� �������
rem javac -d appmodules\userfuncs appsrc\userfuncs\userfuncs\binaryfuncs\BinaryFunc.java
rem ����� ������ module-info.java
rem javac -d appmodules\userfuncs appsrc\userfuncs\module-info.java
rem � ����� ����� � �� � ��
rem javac -d appmodules\appfuncs appsrc\appfuncs\appfuncs\simplefuncs\SimpleMathFuncs.java appsrc\appfuncs\module-info.java
javac --module-source-path appsrc -d appmodules appsrc\userfuncsimp\userfuncsimp\binaryfuncsimp\AbsPlus.java 
rem javac -d appmodules\userfuncsimp appsrc\userfuncsimp\userfuncsimp\binaryfuncsimp\AbsMinus.java 
rem appsrc\userfuncsimp\module-info.java

