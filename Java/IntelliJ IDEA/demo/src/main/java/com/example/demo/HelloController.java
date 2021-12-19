package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSigInButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        //добавляем слушателя событий для authSigInButton
        authSigInButton.setOnAction(event -> {
            //забираем текст из поля loginField удаляем лишние пробелы при
            //помощи метода trim(), помещаем текст в переменную  loginText
            String loginText = loginField.getText().trim();
            // -//-
            String loginPassword = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("") ) {
                loginUser(loginText, loginPassword);
            }
            else {
                System.out.println("Login & Password not found");
            }
        } );
        //ПЕРЕХОД на окно регистрации
        loginSignUpButton.setOnAction(actionEvent -> {

           openNewScene("signUp.fxml");


        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        //next() — возвращает следующий элемент коллекции (объекта)
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1) {
            System.out.println("Success!");
            openNewScene("products.fxml");
        }
        else {
            System.out.println("User not exist / password not correct ");
        }
    }

    public void openNewScene (String window) {
        loginSignUpButton.getScene().getWindow().hide(); // метод сцены, метод окна (котрое в сцене), фун. скрыть
        FXMLLoader loader  = new FXMLLoader();
        //помещаем в loader файл, который он будет загружать
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load(); // загружаем файл
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
