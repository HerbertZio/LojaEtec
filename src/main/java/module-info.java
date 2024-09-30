module br.com.etec.lojaetec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    exports br.com.etec.model to javafx.graphics;
    opens br.com.etec.view to javafx.fxml;

    opens br.com.etec.controller to javafx.fxml;
}
