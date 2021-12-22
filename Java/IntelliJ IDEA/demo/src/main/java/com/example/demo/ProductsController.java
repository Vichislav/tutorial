package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Products> productsTable;

    @FXML
    private TableColumn<Products, Integer> idColumn; // колонка

    @FXML
    private TableColumn<Products, String> nameColumn; //колонка

    @FXML
    private TableColumn<Products, Double> amountColumn; //колонка

    @FXML
    private TableColumn<Products, Double> priceColumn; //колонка

    @FXML
    private TableColumn<Products, String> supplierColumn; //колонка

    @FXML
    private Button remove;

    @FXML
    private Button add;

   /* ObservableList<Products> list = FXCollections.observableArrayList(
            new Products(1, "Roll", 3, 1200, "OAO" )
    );*/

    //кнопка add добавить строку
   @FXML
   private void clickAdd (ActionEvent event) {
       System.out.println("add work"); // проверка
       //через конструктор класса Products создаем экземпляр класса и загоняем туда значение из окон input
       Products products = new Products(
               Integer.parseInt(inputId.getText()),       // id
               inputName.getText(),                       // Name
               Double.parseDouble(inputAmount.getText()), // Amount
               Double.parseDouble(inputPrice.getText()),  // Price
               inputSupplier.getText());                  // Supplier
       ObservableList<Products> products1 = productsTable.getItems();
       products1.add(products);
       productsTable.setItems(products1);
   }

   //кнопка remove удалить строку
    @FXML
    private void clickRemove (ActionEvent event) {
        System.out.println("remove work"); // проверка
        int selectedID = productsTable.getSelectionModel().getSelectedIndex();
        productsTable.getItems().remove(selectedID);
    }




    @FXML
    void initialize (URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize work");


        idColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Products, Double>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Products, Double>("price"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("supplier"));


    }

}
