rem java --module-path target;C:\JavaSA\javafx-sdk-18.0.1\lib\ -m com.example.demofx/com.example.demofx.HelloApplication
rem java --module-path target2;C:\JavaSA\javafx-sdk-18.0.1\lib\ -m com.example.demofx/com.example.demofx.HelloApplication
rem java --module-path out\production;C:\JavaSA\javafx-sdk-18.0.1\lib\ -m yonrupech.start/yonrupech.start.HelloApplication
java --module-path C:\JavaSA\javafx-sdk-18.0.1\lib\;out\production  --module javafx.base,javafx.controls,javafx.fxml out\production\start\yonrupech\start\HelloApplication
