package br.com.etec.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

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
        System.out.println("Método validarUsuario chamado");
        String nomeUsuario = txfUsuario.getText();
        String senhaUsuario = psfSenha.getText();

        if (nomeUsuario.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Informe o nome!", "Você precisa inserir o nome!");
        } else if (senhaUsuario.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Informe a senha!", "Você precisa inserir a senha!");
        } else if (nomeUsuario.equals("admin") && senhaUsuario.equals("123456")) {
            mostrarAlerta(Alert.AlertType.CONFIRMATION, "Acesso permitido!", "Login bem sucedido!");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Acesso Negado!", "Usuário ou senha inválidos");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
