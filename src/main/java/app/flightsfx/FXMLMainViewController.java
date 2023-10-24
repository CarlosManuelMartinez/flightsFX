package app.flightsfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import app.flightsfx.model.Flight;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static app.flightsfx.utils.FileUtils.loadFlights;

public class FXMLMainViewController implements Initializable {
    @FXML
    private TableColumn<Flight, String> colFlightNumber;
    @FXML
    private TableColumn<Flight, String> colDestination;
    @FXML
    private TableColumn<Flight, String> colDeparture;
    @FXML
    private TableColumn<Flight, String> colDuration;
    @FXML
    private TableView tabViewListFlights;
    //@FXML
    //private ListView listFlights;

    @FXML
    private TextField txtFlightNumber;
    @FXML
    private TextField txtDestination;
    @FXML
    private TextField txtDeparture;
    @FXML
    private TextField txtDuration;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnApplyFilter;
    @FXML
    private ChoiceBox choiceFilter;
    @FXML
    private TextField txtSearchFlight;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Flight> flights = loadFlights();

        if (flights != null) {
            ObservableList<Flight> f = FXCollections.observableArrayList(flights);

           // colFlightNumber.setCellValueFactory(new PropertyValueFactory<>(
            //       "flightNumber"));
           // colDestination.setCellValueFactory(new PropertyValueFactory<>(
            //       "destination"));
           // colDeparture.setCellValueFactory(new PropertyValueFactory<>(
             //      "departure"));
            //colDuration.setCellValueFactory(new PropertyValueFactory<>(
              //      "duration"));
            //tabViewListFlights.setItems(f);
        } else {
            System.out.println("ErrorList");
        }

        choiceFilter.getItems().addAll("Show all flights", "Show flights to currently selected city", "Show long flights", "Show next 5 flights", "Show flight duration average");
        String flightNumber = txtFlightNumber.getText();
        String destination = txtDestination.getText();
        String departure = txtDestination.getText();
        String filterSelection = choiceFilter.getSelectionModel().toString();

    }
}