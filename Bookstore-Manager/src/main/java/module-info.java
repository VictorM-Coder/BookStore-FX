module com.br.bookstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.br.bookstore.app;
    opens com.br.bookstore.app to javafx.fxml;
}