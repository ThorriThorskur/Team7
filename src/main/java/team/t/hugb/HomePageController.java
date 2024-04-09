package team.t.hugb;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    private ListView<String> menuListView;

    @FXML
    private Label myLabel;

    @FXML
    private StackPane contentPane;

    String[] options = {"Home", "Flights", "Hotels", "Day tours", "Options"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuListView.getItems().addAll(options);

        // Select "Home" by default in the ListView
        menuListView.getSelectionModel().select("Home");
        // Load the Home view when the application starts
        loadView("Home");

        // Add the listener for changes in the selection
        menuListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                myLabel.setText(newValue); // Update the label to reflect the selection
                loadView(newValue); // Load the view based on the new selection
            }
        });
    }

    private void loadView(String viewName) {
        Node node = null;
        try {
            switch (viewName) {
                case "Home":
                    node = FXMLLoader.load(getClass().getResource("/team/t/hugb/Home.fxml"));
                    break;
                case "Flights":
                    node = FXMLLoader.load(getClass().getResource("/team/t/hugb/Flights.fxml"));
                    break;
                case "Hotels":
                    node = FXMLLoader.load(getClass().getResource("/team/t/hugb/Hotels.fxml"));
                    break;
                case "Day tours":
                    node = FXMLLoader.load(getClass().getResource("/team/t/hugb/DayTours.fxml"));
                    break;
                case "Options":
                    node = FXMLLoader.load(getClass().getResource("/team/t/hugb/Options.fxml"));
                    break;
                default:
                    System.out.println("No panel available for this selection.");
                    break;
            }
            if (node != null) {
                contentPane.getChildren().setAll(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
