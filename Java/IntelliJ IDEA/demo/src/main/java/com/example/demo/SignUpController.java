package com.example.demo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField1;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private Button signUpButton;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private TextField signUpCountry;

    @FXML
    private PasswordField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    void initialize()  {
        DatabaseHandler dbHandler = new DatabaseHandler();

        signUpButton.setOnAction(event -> {
            try {
                dbHandler.signUpUser(signUpName.getText(), signUpLastName.getText(),
                        loginField1.getText(), passwordField1. getText(), signUpCountry.getText(), "Male");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


    }

}
