module com.valantic.sti.tutorial {
    requires javafx.controls;
    requires javafx.fxml;

    requires static lombok;
    requires org.slf4j;
    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.apache.commons.lang3;

    opens com.valantic.sti.tutorial to javafx.fxml;

    exports com.valantic.sti.tutorial;
}
