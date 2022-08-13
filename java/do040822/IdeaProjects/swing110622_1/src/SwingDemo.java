import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    SwingDemo() {
        //Создать новый контейнер
        JFrame jfrm= new JFrame(" Простое приложение Sing");
        //Установить начальные размеры
        jfrm.setSize(1275,500);
        //Завершить работу прогр когда пользов
        //закрывает приложение
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Создать текстовую метку
        JLabel jlabc= new JLabel("C с помощью Swing");
        JLabel jlabn= new JLabel("N с помощью Swing");
        JLabel jlabs= new JLabel("S с помощью Swing");
        JLabel jlabw= new JLabel("W с помощью Swing");
        JLabel jlabe= new JLabel("E с помощью Swing");
        //добавить компонент на панель
        jfrm.add(jlabc, BorderLayout.CENTER);
        jfrm.add(jlabn, BorderLayout.NORTH);
        jfrm.add(jlabs, BorderLayout.SOUTH);
        jfrm.add(jlabw, BorderLayout.WEST);
        jfrm.add(jlabe, BorderLayout.EAST);
        //Отобразить фрейм
        jfrm.setVisible(true);
    }
    public static void main(String args[]){
        // создать фрейм в потоке диспетчерезации событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
