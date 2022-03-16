package com.example.ourapp.saif.chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatphApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ChatphApplication.class.getResource("Chatph.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 937, 690);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch (Exception x){
            x.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}