package com.example.demo;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    private TableView<Product> productsTable;

    @FXML
    private TableColumn<Product, Integer> idColumn; // колонка

    @FXML
    private TableColumn<Product, String> nameColumn; //колонка

    @FXML
    private TableColumn<Product, Double> amountColumn; //колонка

    @FXML
    private TableColumn<Product, Double> priceColumn; //колонка

    @FXML
    private TableColumn<Product, String> supplierColumn; //колонка

    @FXML
    private Button remove;

    @FXML
    private Button add;

    @FXML
    private Button updateDb;

    @FXML
    private Button updateTable;

    @FXML
    private void clickUpdateDb (ActionEvent event) {
        DatabaseHandler dbHandler = new DatabaseHandler();// что бы добраться до метода enterProducts создали экземпляр класса
        System.out.println("пока так"); //проверка

        //nameColumn.getCellValueFactory();



        Product products = new Product(
               // Integer.parseInt(inputId.getText()),       // id
                inputName.getText(),                       // Name
                Double.parseDouble(inputAmount.getText()), // Amount
                Double.parseDouble(inputPrice.getText()),  // Price
                inputSupplier.getText());                  // Supplier

        try {
            dbHandler.enterProducts(products);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("size = " ); //проверка


    }

    //ПЕРЕМЕЩАЕМ ДАННЫЕ ИЗ ДБ В ТАБЛИЦУ
    @FXML
    private void clickUpdateTable (ActionEvent event) {

        DatabaseHandler dbHandler = new DatabaseHandler(); // что бы добраться до метода getDbProducts создали экземпляр класса

        idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("supplier"));

        ResultSet result = dbHandler.getDbProducts();

        //productsTable.getItems();
        ObservableList<Product> products = FXCollections.observableArrayList();

        int counter = 0;
        try {
            while(result.next()) {
                counter++;

                Product product = new Product(result.getInt("idproducts"),
                        result.getString("productsname"),
                        result.getDouble("productsamount"),
                        result.getDouble("productsprice"),
                        result.getString("productssupplier"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        productsTable.setItems(products);

    }


    //кнопка add добавить строку
   @FXML
   private void clickAdd (ActionEvent event) {

       System.out.println("add work"); // проверка

       //через конструктор класса Products создаем экземпляр класса и загоняем туда значение из окон input
       Product products = new Product(
               Integer.parseInt(inputId.getText()),       // id
               inputName.getText(),                       // Name
               Double.parseDouble(inputAmount.getText()), // Amount
               Double.parseDouble(inputPrice.getText()),  // Price
               inputSupplier.getText());                  // Supplier

        // присваиваем отдельной колонке соотвествующее поле(свойство мб) класса
       idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
       nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
       amountColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("amount"));
       priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
       supplierColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("supplier"));


       // вывод значений
       // берем данные(хз может ячейки) из productsTable и помещаем их в
       // products1, который являет собой изменяемый список элементов типа Product
       ObservableList<Product> products1 = productsTable.getItems();
       //добавляем в полученный список данные из products
       products1.add(products);
       //наполняем таблицу данными(хз) из  products1
       productsTable.setItems(products1);


       System.out.println("________________________________"); // проверка

       //чистим инпуты
       inputId.setText("");
       inputName.setText("");
       inputAmount.setText("");
       inputPrice.setText("");
       inputSupplier.setText("");


        //ВЫВОД В ТАБЛИЦУ С БД
       /*DatabaseHandler dbHandler = new DatabaseHandler(); // что бы добраться до метода getDbProducts создали экземпляр класса


       idColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
       nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
       amountColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("amount"));
       priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
       supplierColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("supplier"));

       ResultSet result = dbHandler.getDbProducts();

       //productsTable.getItems();
       ObservableList<Product> products = FXCollections.observableArrayList();

       int counter = 0;
       try {
           while(result.next()) {
               counter++;
               int id = result.getInt("idproducts");
               String name = result.getString("productsname");
               Double amount = result.getDouble("productsamount");

               Product product = new Product(result.getInt("idproducts"),
                       result.getString("productsname"),
                       result.getDouble("productsamount"),
                       result.getDouble("productsprice"),
                       result.getString("productssupplier"));

               products.add(product);

               System.out.println("counter = " + counter + "id = " + id + "productsname " + name + "productsamount" + amount);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

       productsTable.setItems(products);*/
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

    }

    private void enterProductsButton () {

        DatabaseHandler dbHandler = new DatabaseHandler();

        Product products = new Product(
                inputName.getText(),                       // Name
                Double.parseDouble(inputAmount.getText()), // Amount
                Double.parseDouble(inputPrice.getText()),  // Price
                inputSupplier.getText());                  // Supplier

        try {
            dbHandler.enterProducts(products);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
