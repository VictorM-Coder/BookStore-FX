module com.br.bookstore {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.br.bookstore.app;
    opens com.br.bookstore.app to javafx.fxml;
}