package ui.controllers;

import bll.dataformatter.I_DataFormatter;
import bll.dataformatter.JSONFormatter;
import bll.dataformatter.XMLFormatter;
import bll.parser.WebParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ParsePageController implements Initializable, I_Controller {

    @FXML private TextField pageName;
    @FXML private TextField pageURL;
    @FXML private ChoiceBox<String> options;
    @FXML private Button mainMenuBtn;
    @FXML private Label testResult;
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
        if (parser.parse(pageName.getText(), pageURL.getText())) {
            testResult.setTextFill(Color.GREEN);
            testResult.setAlignment(Pos.CENTER);
            testResult.setText("Successful");
        } else {
            testResult.setTextFill(Color.RED);
            testResult.setAlignment(Pos.CENTER);
            testResult.setText("Unsuccessful");
        }
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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ParsePageView.fxml"));
            Scene scene = new Scene(root);
            st.setTitle(this.getName());
            st.setScene(scene);
            st.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void mainMenuBtnHandler() {
        I_Controller c = SingletonFactory.getFactoryInstance().getController("MainMenuController");
        c.changeScene((Stage) mainMenuBtn.getScene().getWindow());
    }
}
