package com.example.ourapp.saif.saif;

import com.example.ourapp.saif.labrassi.LoginApplication;
import com.example.ourapp.saif.najwa.HelloApplication;
import dao.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController {
    @FXML
    private Button registerButton;
    @FXML
    private Button precedentButton;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;

 /*   public void initialize(URL url, ResourceBundle resourceBundle){

    }*/


    public void registerButtonOnAction(ActionEvent event) {
        if ((setPasswordField.getText() == "") || (confirmPasswordField.getText() == "")) {
            confirmPasswordLabel.setText("mot de passe est vide");

        } else if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            confirmPasswordLabel.setText("");
            registrationMessageLabel.setText("enregistrement evec sucee");
            registerUser();
        }
        else {
            confirmPasswordLabel.setText("mot de passe saisi incorect");
        }

    }

    public void closeButtonOnAction(ActionEvent Event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    DataBaseConnection connectnow = new DataBaseConnection();

    public void signIn() {

    }

    public void registerUser() {
        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = setPasswordField.getText();
        String insertToRegister = "insert into account(firstname,lastname,username,password) values('" + firstname + "','" + lastname + "','" + username + "','" + password + "');";
        try {
            connectnow.stm.executeUpdate(insertToRegister);
            registrationMessageLabel.setText("user sucees");
            System.out.println("succes");
            afficherLogin();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }

    }

    //afficher login
    public void afficherHello(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Hello-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            Stage pstage = (Stage) precedentButton.getScene().getWindow();
            pstage.close();
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public void afficherLogin() {

        try {
/*****************************************/
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
            Stage primaryStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            primaryStage.setTitle("4MNBOT");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.close();
/*****************************************/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

