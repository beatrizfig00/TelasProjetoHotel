module com.example.telasprojeto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.telasprojeto to javafx.fxml;
    exports com.example.telasprojeto;
}