package com.valantic.sti.tutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.net.URL;

public class Main extends Application {

    Stage window;

    public static void main(final String... args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        window = stage;
        window.setTitle("Validation");

        final Button button1 = new Button("ControlsFX");
        button1.setOnAction(e -> loadValidateFxExample("ControlsFX", "controlsfx-login-mask.fxml"));

        final Button button2 = new Button("ValidateFX");
        button2.setOnAction(e -> loadValidateFxExample("ValidateFX", "validatefx-login-mask.fxml"));

        final VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button1, button2);

        final Scene scene = new Scene(layout, 100, 100);
        window.setScene(scene);
        window.show();
    }

    @SneakyThrows
    private void loadValidateFxExample(final String title, final String fxmlFilename) {
        final Stage window = new Stage();
        window.setTitle(title);
        final URL location = getClass().getResource(fxmlFilename);
        final FXMLLoader loader = new FXMLLoader(location);
        final VBox layout = loader.load();
        final Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}
