package yonrupech.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
// ���� � ������� ���� ���������� � / ��� ������ ����� � ����� ������� 
// �.�. ��������, � ����� --module-path target2  ���� ����� res3
// ���� ��� / �� ��� ����� ��� ���� ������ ����� � *.class
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
=======
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("res/hello-view.fxml"));
>>>>>>> 74231e3629818055a23f583dd125108142fd6d45
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}