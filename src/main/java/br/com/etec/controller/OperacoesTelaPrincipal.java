package br.com.etec.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.awt.*;
        import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class OperacoesTelaPrincipal {

    @FXML
    Button btnTipo;
    @FXML
    Button btnMarca;
    @FXML
    Button btnModelo;

    @FXML
    ComboBox<String> cmbTipo;
    @FXML
    ComboBox<String> cmbMarca;
    @FXML
    ComboBox<String> cmbModelo;

    //Inicia valores das combobox
    public void initialize(URL url, ResourceBundle rb){

        ObservableList<String> lista = FXCollections.observableArrayList("Tênis", "Chinelo");
        cmbTipo.setItems(lista);

        ObservableList<String> lista2 = FXCollections.observableArrayList("Nike", "Adidas");
        cmbMarca.setItems(lista2);

        ObservableList<String> lista3 = FXCollections.observableArrayList("TEN001 (Jordan)", "TEN002 (Shox)", "CHN001 (And1)", "TEA001 (Swift Run)", "CHA001 (Adinova)");
        cmbModelo.setItems(lista3);
    }
}
