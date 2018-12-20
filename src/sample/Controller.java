package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import sun.security.util.Password;

public class Controller
{
    public static List<Integer> list = new ArrayList<Integer>();

    public static void enterList() //функция для ввода списка
    {
        Random random = new Random(System.currentTimeMillis());

        for(int i = 0; i < 100; i++)
        {
            int number = -100 + random.nextInt(101 + 100);
            list.add(number);
        }
    }

    public static void printList() //функция для вывода списка
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args)
    {
        enterList();
        printList();

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

        printList();

        System.out.println();
    }
}
