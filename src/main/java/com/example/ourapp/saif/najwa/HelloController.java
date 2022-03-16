package com.example.ourapp.saif.najwa;

import com.example.ourapp.saif.labrassi.LoginApplication;
import com.example.ourapp.saif.saif.Register;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HelloController {
    @FXML
    private Button helloCommencer;
    @FXML
    private Button helloLogin;

    //fenetre login
    public  void afficherLoginOnAction(ActionEvent e){

        if(e.getSource()==helloLogin){
            try{
                System.out.println("hello");
/*****************************************/
                FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
                Stage primaryStage =new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                primaryStage.setTitle("4MNBOT");
                primaryStage.initStyle(StageStyle.UNDECORATED);
                primaryStage.setScene(scene);
                primaryStage.show();
                Stage stage = (Stage) helloLogin.getScene().getWindow();
                stage.close();
/*****************************************/
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    //fenetre commence
    public  void afficherCommencerOnAction(ActionEvent e){

        if(e.getSource()==helloCommencer){
            try{
                System.out.println("commencer");
/*****************************************/
                FXMLLoader fxmlLoader = new FXMLLoader(Register.class.getResource("register.fxml"));
                Stage primaryStage =new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 920, 720);
                primaryStage.setTitle("4MNBOT");
                primaryStage.initStyle(StageStyle.UNDECORATED);
                primaryStage.setScene(scene);
                primaryStage.show();
                Stage stage = (Stage) helloCommencer.getScene().getWindow();
                stage.close();
/*****************************************/
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

}
