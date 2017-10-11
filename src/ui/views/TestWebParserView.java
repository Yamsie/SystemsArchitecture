package ui.views;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;


public class TestWebParserView implements I_View {

    public TestWebParserView(){ }

    public void runView(Stage st){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/testselection.fxml"));
            //s.setRoot(root);
            //st.setScene(s);
        }
        catch(IOException ex){
            System.out.println("Error - IO exception");
        }
    }
}
