package br.com.etec.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Operacoes {
    @FXML
    private Label labelMensagem;

    @FXML
    public void mostrarMensagem() {
        labelMensagem.setText("Você clicou no Breguenaite!");
    }
}