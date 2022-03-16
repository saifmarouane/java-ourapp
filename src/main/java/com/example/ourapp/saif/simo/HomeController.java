package com.example.ourapp.saif.simo;

import com.example.ourapp.saif.chat.ChatphApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button robot1;
    @FXML

    public void showrobot1(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ChatphApplication.class.getResource("Chatph.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 937, 690);
            Stage stage =new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
            Stage dstage = (Stage) robot1.getScene().getWindow();
            dstage.close();

        }
        catch (Exception ed){
            ed.printStackTrace();
        }


    }

}