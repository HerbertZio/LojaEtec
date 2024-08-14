package br.com.etec.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/etec/view/tela-inicial.fxml"));
        Scene scene = new Scene(loader.load(),300,100);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Abrir Breguenaite!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}