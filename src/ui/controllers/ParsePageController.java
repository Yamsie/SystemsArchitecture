package ui.controllers;

import bll.models.dataformatter.I_DataFormatter;
import bll.models.dataformatter.JSONFormatter;
import bll.models.dataformatter.XMLFormatter;
import bll.models.parser.WebParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ParsePageController implements Initializable, IController {

    @FXML private TextField pageName;
    @FXML private TextField pageURL;
    @FXML private ChoiceBox<String> options;
    private WebParser parser;
    private I_DataFormatter [] formatter = {new XMLFormatter(), new JSONFormatter()};


    public ParsePageController() {
        parser = new WebParser();
    }

    @FXML
    public void changeFormat() {
        parser.setFileFormat(options.getValue().equals("XML") ? formatter[0] : formatter[1]);
    }

    @FXML
    protected void parsePage() {
        parser.parse(pageName.getText(), pageURL.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        options.getItems().removeAll(options.getItems());
        options.getItems().addAll("XML", "JSON");
        options.getSelectionModel().select("XML");
    }

    public String getName(){
        return "ParsePageController";
    }

    public void changeScene(Stage st){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/parsepage.fxml"));
            Scene scene = new Scene(root);
            st.setTitle(this.getName());
            st.setScene(scene);
            st.show();
        }
        catch(Exception ex){
            System.out.println("Exception caught in ParsePageController changeScene()");
        }
    }
}
