import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Form1 extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JList list2;

    public Form1(Stage window) throws Exception {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



            window.setTitle("JavaFX");
            VBox root = new VBox();

            javafx.scene.control.Button StartGenerate = new javafx.scene.control.Button("Сгенерировать");
            javafx.scene.control.Button Calculate = new Button("Расчет");

            Double minHeight = 30.0;
            Double minWidth = 120.0;

            StartGenerate.setMinHeight(minHeight);
            StartGenerate.setMinWidth(minWidth);

            Calculate.setMinHeight(minHeight);
            Calculate.setMinWidth(minWidth);

            ListView<java.util.List> SourceList = new ListView();
            ListView<List> ListCalculatedValues = new ListView();
            SourceList.setOrientation(Orientation.HORIZONTAL);
            ListCalculatedValues.setOrientation(Orientation.HORIZONTAL);

            root.getChildren().addAll(SourceList,ListCalculatedValues,StartGenerate,Calculate);

            StartGenerate.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    SourceList.getItems().addAll(enterList());
                }
            });

            Calculate.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    ListCalculatedValues.getItems().addAll(printList());
                }
            });


            window.setScene(new Scene(root, 300, 275));
            window.show();



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        public static void main(String[] args) {
            launch(args);
        }

        public static List<Integer> list = new ArrayList<Integer>();

        public static List<Integer> enterList() //функция для ввода списка
        {
            Random random = new Random(System.currentTimeMillis());

            for(int i = 0; i < 100; i++)
            {
                int number = -100 + random.nextInt(101 + 100);
                list.add(number);
            }
            return list;
        }
        dispose();
    }

    private void onCancel() {
        public static List<Integer> list = new ArrayList<Integer>();
        public static List<Integer> printList() //функция для вывода списка
        {
            int i = 0;
            int res = 0;
            while(i < list.size() - res)
            {
                if(list.get(i) < 0)
                {
                    list.add(list.get(i));
                    list.remove(list.get(i));
                    res++;
                }
                else
                    i++;
            }
            return list;
        }
        dispose();
    }

    public static void main(String[] args) {
        Form1 dialog = new Form1();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
