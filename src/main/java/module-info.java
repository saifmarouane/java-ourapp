module com.example.ourapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;


    exports dao;
    opens dao to javafx.fxml;
    exports com.example.ourapp.saif.chat;
    opens com.example.ourapp.saif.chat to javafx.fxml;
    exports com.example.ourapp.saif.saif;
    opens com.example.ourapp.saif.saif to javafx.fxml;
    exports com.example.ourapp.saif.labrassi;
    opens com.example.ourapp.saif.labrassi to javafx.fxml;
    exports com.example.ourapp.saif.simo;
    opens com.example.ourapp.saif.simo to javafx.fxml;

    exports com.example.ourapp.saif.najwa;
    opens com.example.ourapp.saif.najwa to javafx.fxml;

}