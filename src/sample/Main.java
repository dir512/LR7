package sample;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception {


        window.setTitle("JavaFX");
        VBox root = new VBox();

        Button StartGenerate = new Button("Сгенерировать");
        Button Calculate = new Button("Расчет");

        Double minHeight = 30.0;
        Double minWidth = 120.0;

        StartGenerate.setMinHeight(minHeight);
        StartGenerate.setMinWidth(minWidth);

        Calculate.setMinHeight(minHeight);
        Calculate.setMinWidth(minWidth);

        ListView<List> SourceList = new ListView();
        ListView<List> ListCalculatedValues = new ListView();
        SourceList.setOrientation(Orientation.HORIZONTAL);
        ListCalculatedValues.setOrientation(Orientation.HORIZONTAL);

        root.getChildren().addAll(SourceList,ListCalculatedValues,StartGenerate,Calculate);

        StartGenerate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SourceList.getItems().addAll(enterList());
            }
        });

        Calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListCalculatedValues.getItems().addAll(printList());
            }
        });


        window.setScene(new Scene(root, 300, 275));
        window.show();
    }

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
}
