package gui.JavaFX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button homeBtn;
    @FXML
    private Button inputBtn;
    @FXML
    private Button analysisBtn;
    @FXML
    private Button aboutBtn;

    @FXML
    private VBox homePageVBox;
    @FXML
    private VBox inputPageVBox;
    @FXML
    private VBox analysisPageVBox;

    @FXML
    private TextField inputCSVPath;
    @FXML
    private TextField outputCSVPath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        homePageVBox.toFront();
    }

    public void homeButtonClicked(ActionEvent actionEvent) {
        homePageVBox.toFront();
    }

    public void inputButtonClicked(ActionEvent actionEvent) {
        inputPageVBox.toFront();
    }

    public void analysisButtonClicked(ActionEvent actionEvent) {
        analysisPageVBox.toFront();
    }

    public void aboutButtonClicked(ActionEvent actionEvent) {
        //TODO: Add the aboutPageBox when it's implemented
    }

    //TODO: Add ActionListeners for the file path selection

    //TODO: Add ActionListener for Update
}
