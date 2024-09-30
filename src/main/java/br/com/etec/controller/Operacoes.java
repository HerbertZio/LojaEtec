package br.com.etec.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.etec.util.Conexao;

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
        String nomeUsuario = txfUsuario.getText();
        String senhaUsuario = psfSenha.getText();

        if (nomeUsuario.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Informe o nome!", "Você precisa inserir o nome!");
        } else if (senhaUsuario.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Informe a senha!", "Você precisa inserir a senha!");
        } else if (validarUsuarioNoBanco(nomeUsuario, senhaUsuario)) {
            mostrarAlerta(Alert.AlertType.CONFIRMATION, "Acesso permitido!", "Login bem sucedido!");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Acesso Negado!", "Usuário ou senha inválidos");
        }
    }

    private boolean validarUsuarioNoBanco(String usuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Retorna true se houver um usuário correspondente
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void cadastrarUsuario(ActionEvent event) {
        String nomeUsuario = txfUsuario.getText();
        String senhaUsuario = psfSenha.getText();

        if (nomeUsuario.isEmpty() || senhaUsuario.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Dados Inválidos", "Por favor, preencha todos os campos.");
            return;
        }

        if (cadastrarNoBanco(nomeUsuario, senhaUsuario)) {
            mostrarAlerta(Alert.AlertType.CONFIRMATION, "Cadastro realizado!", "Usuário cadastrado com sucesso!");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro no Cadastro", "Não foi possível cadastrar o usuário.");
        }
    }

    private boolean cadastrarNoBanco(String usuario, String senha) {
        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
