package com.example.ourapp.saif.labrassi;

import com.example.ourapp.saif.saif.Register;
import com.example.ourapp.saif.simo.HomeApplication;
import dao.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button login_sIncrireButton;
    @FXML
    private Button login_quitterButton;
    @FXML
    private TextField login_usernameTextField;
    @FXML
    private PasswordField login_passwordPasswordField;
    @FXML
    private Label login_messageLabel;

    @FXML
    public void login_seConnecterButtonOnAction(ActionEvent e) {
        if (login_usernameTextField.getText().isBlank() == false && login_passwordPasswordField.getText().isBlank() == false) {
//         login_messageLabel.setText("You try to login!");
            validateLogin();

        } else {
            login_messageLabel.setText("Entrer votre nom d'utilisateur et mot de passe");
        }
    }

    @FXML
    public void login_quitterButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) login_quitterButton.getScene().getWindow();
        stage.close();
    }

    DataBaseConnection connectnow = new DataBaseConnection();

    @FXML
    public void validateLogin() {
        String username = login_usernameTextField.getText();
        String password = login_passwordPasswordField.getText();
        String verifyLogin = "SELECT count(1) from account where username = '" + login_usernameTextField.getText() + "' and password = '" + login_passwordPasswordField.getText() + "' ";
        try {
            ResultSet queryResult = connectnow.stm.executeQuery(verifyLogin);


            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    login_messageLabel.setText("Bienvenue!");
                    afficherHome();
                } else {
                    login_messageLabel.setText("Nom d'utilisateur ou mot de passe incorrect.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //
    public void afficherHome(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("Home.fxml"));
            Stage stage=new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }catch (Exception ed){
            ed.printStackTrace();
        }

    }
    //

    public  void afficherCommencer(ActionEvent e){
        if (e.getSource()==login_sIncrireButton){
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
                Stage stage = (Stage) login_sIncrireButton.getScene().getWindow();
                stage.close();
    /*****************************************/
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }


    }
}
