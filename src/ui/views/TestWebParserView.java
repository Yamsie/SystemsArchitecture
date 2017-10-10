package ui.views;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class TestWebParserView implements I_View {

    public TestWebParserView(){ }

    public void runView(Scene s){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/testselection.fxml"));
            s.setRoot(root);
        }
        catch(IOException ex){
            System.out.println("Error - IO exception");
        }
    }
}
