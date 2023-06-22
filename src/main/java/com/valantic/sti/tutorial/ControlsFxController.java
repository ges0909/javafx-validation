package com.valantic.sti.tutorial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@Getter
public class ControlsFxController implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextArea textarea;

    private final ValidationSupport validationSupport = new ValidationSupport();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validationSupport.registerValidator(username, Validator.createEmptyValidator("Username is required"));
        validationSupport.registerValidator(password, Validator.createEmptyValidator("Password is required"));
    }

    public void handleLogin(ActionEvent event) {
        log.info("Button '{}' clicked", ((Button) event.getSource()).getText());
    }
}
