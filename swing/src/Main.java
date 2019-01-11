import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;

public class Main {
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

    public static void run() {
        final JFrame window = new JFrame("JavaSwing");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();

        JButton StartGenerate = new JButton("Сгенерировать");
        JButton Calculate = new JButton("Расчет");

        DefaultListModel listModel_SourceList = new DefaultListModel();
        DefaultListModel listModel_ListCalculatedValues = new DefaultListModel();

        JList SourceList = new JList(listModel_SourceList);
        JList ListCalculatedValues = new JList(listModel_ListCalculatedValues);

        SourceList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        ListCalculatedValues.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        StartGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel_SourceList.addElement(enterList());
            }
        });

        Calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel_ListCalculatedValues.addElement(printList());
            }
        });

        panel.add(StartGenerate);
        panel.add(Calculate);
        panel.add(SourceList);
        panel.add(ListCalculatedValues);

        //Добавим панель в окно
        window.getContentPane().add(panel);
        window.pack();

        //Разместим программу по центру
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    //Запускаем
    public static void main(String[] args) {
        run();
    }
}
