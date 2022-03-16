package com.example.ourapp.service;

import dao.DataBaseConnection;
import dao.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class UserService implements UserDao {


    @FXML
    private ImageView shieldImageView;
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
    DataBaseConnection connectnow = new DataBaseConnection();
    @Override
    public  void registerUser() {
        System.out.println("ee");
        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = setPasswordField.getText();
        String insertToRegister = "insert into account(firstname,lastname,username,password) values('"+firstname+"','"+lastname+"','"+username+"','"+password+"');";
        try {
            connectnow.stm.executeUpdate(insertToRegister);
            registrationMessageLabel.setText("user sucees");
            System.out.println("succes");



        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();}
    }

    @Override
    public void singinUser() {

    }
}
