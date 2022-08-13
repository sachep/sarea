import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;

public class JavaFxSkel extends Application{
    public static void main(String[] args){
        System.out.println("Запуск приложения JavaFx");
        //
        launch(args);
    }
    //переопределить метод инит
    public void init(){
        System.out.println("В init()");
    }
    // переопределить метод старт
    public void start(Stage myStage){
        System.out.println("В start()");
        //Заголовок
        myStage.setTitle("Каркас приложения JavaFx");
        //Корневой узел
        FlowPane rootNode=new FlowPane();
        //создать сцену
        Scene myScene=new Scene(rootNode,300,200);
        //установить сцену на платформе
        myStage.setScene(myScene);
        //отобразить сцену
        myStage.show();
    }
    // переопределить метод стоп
    public void stop(){
        System.out.println("В stop()");
    }
}
