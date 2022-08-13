import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

class Sw_button120622 implements ActionListener {
        JLabel jlab;
        //
        Sw_button120622() {
                // окно для кнопок
                JFrame jfrm = new JFrame("Пример кнопки");
                jfrm.setLayout(new FlowLayout());
                jfrm.setSize(330, 90);
                jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // создать две кнопки
                JButton jbtnUp = new JButton("Отпущена");
                JButton jbtnDown = new JButton("Нажата");
                JButton jbtn3 = new JButton("Нажата3");
                //слушатели
                jbtnUp.addActionListener(this);
                jbtnDown.addActionListener(this);
                jbtn3.addActionListener(this);
                //кнопки на панель
                jfrm.add(jbtnUp);
                jfrm.add(jbtnDown);
                jfrm.add(jbtn3);
                //создать панельку для сообщений
                jlab = new JLabel("Нажать кнопку");
                jfrm.add(jlab);
                jfrm.setVisible(true);
        }
                //обработка событий кнопки - имплементация  метода
                public void actionPerformed(ActionEvent ae){
                        if(ae.getActionCommand().equals("Нажата"))
                                jlab.setText("Кнопка отпущена");
                        else
                                jlab.setText("Кнопка нажата");
                }
                public static void main(String args[]){
                SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                                new Sw_button120622();
                        }
                });
                }



        }

