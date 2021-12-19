package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ProductsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView homeImage;

    @FXML
    private HBox inputBox;

    @FXML
    private TextField inputId; // окно ввода текста

    @FXML
    private TextField inputName; // окно ввода текста

    @FXML
    private TextField inputAmount; // окно ввода текста

    @FXML
    private TextField inputPrice; // окно ввода текста

    @FXML
    private TextField inputSupplier; // окно ввода текста

    @FXML
    private TableView<?> productsTable;

    @FXML
    private TableColumn<?, ?> id; // колонка

    @FXML
    private TableColumn<?, ?> name; //колонка

    @FXML
    private TableColumn<?, ?> amount; //колонка

    @FXML
    private TableColumn<?, ?> price; //колонка

    @FXML
    private TableColumn<?, ?> supplier; //колонка

    @FXML
    private Button remove;

    @FXML
    private Button add;



    @FXML
    void initialize() {
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'app.fxml'.";
        assert amount != null : "fx:id=\"amount\" was not injected: check your FXML file 'app.fxml'.";
        assert homeImage != null : "fx:id=\"homeImage\" was not injected: check your FXML file 'app.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'app.fxml'.";
        assert inputAmount != null : "fx:id=\"inputAmount\" was not injected: check your FXML file 'app.fxml'.";
        assert inputBox != null : "fx:id=\"inputBox\" was not injected: check your FXML file 'app.fxml'.";
        assert inputId != null : "fx:id=\"inputId\" was not injected: check your FXML file 'app.fxml'.";
        assert inputName != null : "fx:id=\"inputName\" was not injected: check your FXML file 'app.fxml'.";
        assert inputPrice != null : "fx:id=\"inputPrice\" was not injected: check your FXML file 'app.fxml'.";
        assert inputSupplier != null : "fx:id=\"inputSupplier\" was not injected: check your FXML file 'app.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'app.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'app.fxml'.";
        assert productsTable != null : "fx:id=\"productsTable\" was not injected: check your FXML file 'app.fxml'.";
        assert remove != null : "fx:id=\"remove\" was not injected: check your FXML file 'app.fxml'.";
        assert supplier != null : "fx:id=\"supplier\" was not injected: check your FXML file 'app.fxml'.";

    }

}
