package gui.JavaFX.controllers;

import backend.utility.Input;
import backend.utility.Output;
import backend.utility.splitObjects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String fileAddress;
    private String fileDirectory;

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

    public void inputFileButtonClicked(ActionEvent actionEvent) {
        fileAddress = inputCSVPath.getText();
    }

    public void outputFileButtonClicked(ActionEvent actionEvent) {
        fileDirectory = outputCSVPath.getText();
    }

    public void updateBtnClicked(ActionEvent actionEvent) {
        Output.outputWriter(splitObjects.splitObjectTransfer(Input.parseDexcomCSV(fileAddress)), fileDirectory);
    }

    //TODO: Add ActionListener for Update
}
