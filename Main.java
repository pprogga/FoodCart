package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField textField1 = new TextField();
        textField1.setPromptText("Item");
        TextField textField2 = new TextField();
        textField2.setPromptText("Quantity");
        TextField textField3 = new TextField();
        textField3.setPromptText("Price");
        Button button = new Button("Add to Cart");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(12);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(textField1, 0, 0);
        gridPane.add(textField2, 0, 1);
        gridPane.add(textField3, 0, 2);
        gridPane.add(button, 0, 3);


        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Assignment");
        primaryStage.show();


        GridPane gridPane1 = new GridPane();
        Button button1 = new Button("Add");
        gridPane1.add(button1, 0, 0);
        Text txt1 = new Text(" Menu Name");
        gridPane1.add(txt1, 0, 1);
        Text txt2 = new Text("Qt.");
        gridPane1.add(txt2, 1, 1);
        Text txt3 = new Text("Price");
        gridPane1.add(txt3, 2, 1);
        gridPane1.setHgap(120);
        gridPane1.setVgap(20);

        TextArea textArea = new TextArea();
        Text txt = new Text();
        Button button2 = new Button("Exit");

        VBox vbox = new VBox(gridPane1, textArea, txt, button2);
        Scene nextScene = new Scene(vbox, 600, 400);

        button2.setOnAction(e -> {
            primaryStage.close();
        });


        button1.setOnAction(e -> {
            primaryStage.setScene(scene);
            textField1.clear();
            textField2.clear();
            textField3.clear();
        });

        final int[] subtotal = {0};
        button.setOnAction(e -> {
            primaryStage.setScene(nextScene);
            String name = textField1.getText();
            String quantity = textField2.getText();
            String price = textField3.getText();
            textArea.appendText(name + "\t\t\t\t\t\t" + quantity + "\t\t\t\t\t" + price + "\n");
            int i = Integer.parseInt(quantity);
            int j = Integer.parseInt(price);
            int total;
            total = i * j;
            subtotal[0] += total;
            String s = Integer.toString(subtotal[0]);
            txt.setText("\nTotal Price:           " + s + " Taka\n");

        });


    }


}


