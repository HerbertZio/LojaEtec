module br.com.etec.lojaetec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    // Exporta pacotes para os módulos JavaFX
    exports br.com.etec.model to javafx.graphics;
    opens br.com.etec.view to javafx.fxml;

    // Adiciona a abertura do pacote para o controlador, se necessário
    opens br.com.etec.controller to javafx.fxml;
}
