
import javafx.application.*;// все javafx отсюда
import javafx.stage.*; // подмостки пространство
import javafx.scene.*; // сама сцена
import javafx.scene.layout.*; // панели компоновки
// выше это минимум для импорта
import javafx.scene.control.*; //  отсюда  родом компоненты сцены
import javafx.event.*;// обработчик событий
import javafx.geometry.*; // здесь список констант выравнивания для панели компоновки

import java.util.List;


public class JavaFXEventDemo extends Application{
    //Label response;
    public static void main(String[] args){
        //запуск приложения
        launch(args);
    }
    // переопределить start
    public void start(Stage myStage) {
        //задать заголовок окна
        myStage.setTitle("Использование кнопок и событий JavaFX");
        // использовать компоновку FlowPane  но можно и другие
        FlowPane rootNode = new FlowPane(10, 10);
        //центировать компненты
        rootNode.setAlignment(Pos.CENTER);
        //создать сцену
        Scene myScene = new Scene(rootNode, 300, 300);
        //установить сцену на платформе
        myStage.setScene(myScene);
        // выше это всегда начало так, а потом элементы

        //создать метку
        var response = new Label("Нажмите кнопку");
        //var это выведение типа локальной переменной, здесь var вместо Label
        //создать две кнопки
        Button btnUp = new Button("Вверх");
        Button btnDown = new Button("Вниз");
        // назначить слушателей (через анонимные классы) и  обработать
        // события действия
        btnUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("Вы нажали ВВЕРХ");
            }
        });
        btnDown.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {    //создание - переопределение обраб события
                response.setText("Вы нажали ВНИЗ");
            }
        });
        // другой способ : можно передать методу лямбда-выражение см ниже
        //btnDown.setOnAction((ae)->response.setText("Вы нажали ВНИЗ"));
        // Добавить метку и кнопки в граф сцены
        System.out.println(rootNode.getChildren().size()); //изучение методов работы со списками
        System.out.println(rootNode.getChildren().isEmpty());//изучение методов работы со списками
        rootNode.getChildren().addAll(btnUp, btnDown, response);//собственно добавление
        System.out.println(rootNode.getChildren());//изучение методов работы со списками
        System.out.println(rootNode.getChildren().size());//изучение методов работы со списками

        //отобразить платформу со сценой
        myStage.show();
    }
}
