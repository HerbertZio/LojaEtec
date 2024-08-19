package br.com.etec.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Operacoes {

    @FXML
    private TextField txfUsuario;
    @FXML
    private PasswordField psfSenha;
    @FXML
    private Button btnAcessar;
    @FXML
    private Button btnCadastrar;

    @FXML
    private void validarUsuario(ActionEvent event) {
        String nomeUsuario;
        nomeUsuario = txfUsuario.getText();
        String senhaUsuario;
        senhaUsuario = psfSenha.getText();

        if(nomeUsuario.isEmpty() || senhaUsuario.isEmpty()){
            if(nomeUsuario.isEmpty()){
                //nome vazio
            } else {
                // Senha vazia
            }
        }
    }
}