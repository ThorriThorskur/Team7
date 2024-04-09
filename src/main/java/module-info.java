module team.t.hugb {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens team.t.hugb to javafx.fxml;
    exports team.t.hugb;
}