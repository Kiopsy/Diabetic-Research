package gui.JavaFX.controllers;

import backend.utility.Input;
import backend.utility.Output;
import backend.utility.splitObjects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String fileAddress;
    private String fileDirectory;


    //buttons on the left side of the GUI
    @FXML
    private Button homeButton;
    @FXML
    private Button inputButton;
    @FXML
    private Button analysisButton;
    @FXML
    private Button aboutButton;

    //Top right MenuButton and MenuItem
    @FXML
    private MenuButton userMenuButton;
    @FXML
    private MenuItem signOutMenuItem;
    @FXML
    private MenuItem accountMenuItem;

    //Home page components
    @FXML
    private VBox homeVBox;
    @FXML
    private Label fullNameLabel;
    @FXML
    private Label userBirthDateLabel;
    @FXML
    private Label userNameLabel;
    @FXML
    private Button signOutButton;
    @FXML
    private Button accountDetailsButton;

    //Analysis page components
    @FXML
    private VBox analysisVBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Button goButton;


    //Input page components
    @FXML
    private VBox inputVBox;
    @FXML
    private TextField importTextField;
    @FXML
    private TextField directoryTextField;
    @FXML
    private Button importFileButton;
    @FXML
    private Button directoryFileButton;
    @FXML
    private Button inputUpdateButton;



    //About page components
        //TODO: Add when About page is implemented

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputVBox.toFront();
    }

    public void homeButtonClicked(ActionEvent actionEvent) {
        homeVBox.toFront();
    }

    public void inputButtonClicked(ActionEvent actionEvent) {
        inputVBox.toFront();
    }

    public void analysisButtonClicked(ActionEvent actionEvent) {
        analysisVBox.toFront();
    }

    public void aboutButtonClicked(ActionEvent actionEvent) {
        //TODO: Add the aboutPageBox when it's implemented
    }

    public void inputFileButtonClicked(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);

        if (file != null) {

            importFileButton.setText(file.getAbsolutePath());
        }
    }

    public void outputFileButtonClicked(ActionEvent actionEvent){
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);

        if (file != null) {

            directoryFileButton.setText(file.getAbsolutePath());
        }
    }

    public void inputUpdateButtonClicked(ActionEvent actionEvent) {
        fileAddress = importTextField.getText();
        fileDirectory = directoryTextField.getText();
        Output.outputWriter(splitObjects.splitObjectTransfer(Input.parseDexcomCSV(fileAddress)), fileDirectory);
    }
    @FXML
    void goButtonClicked(ActionEvent event) {

    }
    @FXML
    void accountDetailsButtonClicked(ActionEvent event) {

    }
    @FXML
    void signOutButtonClicked(ActionEvent event) {

    }
    @FXML
    void accountMenuItemClicked(ActionEvent event) {

    }

    @FXML
    void signOutMenuItemClicked(ActionEvent event) {

    }
    //TODO: Add ActionListener for Update
}
