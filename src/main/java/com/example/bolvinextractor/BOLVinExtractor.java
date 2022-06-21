package com.example.bolvinextractor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.bolvinextractor.HelloController.rectGroup;

public class BOLVinExtractor extends Application {

    ToggleGroup tg = new ToggleGroup();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BOLVinExtractor.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BOL VIN Extractor");

        StackPane imageStackPane = (StackPane) scene.lookup("#image_bol_stack_pane");
       imageStackPane.getChildren().add(rectGroup);
//
//       HelloController helloControllerClass = new HelloController();
//        RadioButton rb1 = (RadioButton) scene.lookup("#bar_code_mode");
//        RadioButton rb2 = (RadioButton) scene.lookup("#text_recongition_mode");
//        rb1.setToggleGroup(tg);
//        rb2.setToggleGroup(tg);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }



}
