package com.valantic.sti.tutorial;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.synedra.validatorfx.Check;
import net.synedra.validatorfx.Validator;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class ValidateFxController implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextArea problemTextArea;

    @FXML
    private Button loginButton;

    private final Validator validator = new Validator();

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        validator.createCheck()
                .withMethod(this::checkUsernameAndPassword)
                .dependsOn("username", usernameTextField.textProperty()) // declare a named property
                .dependsOn("password", passwordTextField.textProperty())
                .decorates(usernameTextField) // can decorate any node or call c.warn("...")
                .decorates(passwordTextField)
                .immediate(); // validate immediately
        loginButton.disableProperty().bind(
                validator.containsErrorsProperty() // 'ReadOnlyBooleanProperty' to check if there are errors
        );
        final StringBinding validationResultsStringBinding = Bindings.createStringBinding(
                this::getValidationResultsAsString,
                validator.validationResultProperty() // all warnings and errors plus messages
        );
        problemTextArea.textProperty().bind(validationResultsStringBinding);
    }

    public void handleLogin(final ActionEvent event) {
        log.info("Button '{}' clicked: username = {}, password = {}",
                ((Button) event.getSource()).getText(), usernameTextField.getText(), passwordTextField.getText());
    }

    private void checkUsernameAndPassword(final Check.Context context) {
        final String username = context.get("username");
        final String password = context.get("password");
        if (!StringUtils.isAllLowerCase(username)) {
            context.error("Must have lowercase letters only.");
        }
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            context.error("Must not be empty.");
        }
        if (username.length() < 4) {
            context.error("Username must have at least 4 characters.");
        }
        if (password.length() < 8) {
            context.error("Password must have at least 8 characters.");
        }
    }

    private String getValidationResultsAsString() {
        return validator.validationResultProperty().get().getMessages().stream()
                .map(msg -> msg.getSeverity().toString() + ": " + msg.getText())
                .collect(Collectors.joining("\n"));
    }
}
