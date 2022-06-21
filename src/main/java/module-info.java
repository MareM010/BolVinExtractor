module com.example.bolvinextractor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires tess4j;
    requires opencv;
    requires java.desktop;
    requires javafx.swing;
    requires com.google.zxing;
    requires com.google.zxing.javase;

    opens com.example.bolvinextractor to javafx.fxml;
    exports com.example.bolvinextractor;
}