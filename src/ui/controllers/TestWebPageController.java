package ui.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ui.views.TestWebPageView;

import java.awt.event.ActionListener;

public class TestWebPageController implements IController {
    private TestWebPageView view;
    //private testwebpagemodel model; not implement
    private Button test;

    public TestWebPageController() { }

    public TestWebPageController(TestWebPageView view /*,model*/){
      this.view = view;
      //this.model = model;
      this.view.SubmitListener(new SubListener());
    }
    class SubListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            String web = view.getWebChoosed();
        }
    }

    public String getName(){
        return "TestWebPageController";
    }

    public void changeScene(Stage st){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/testwebpage.fxml"));
            Scene scene = new Scene(root);
            st.setTitle(this.getName());
            st.setScene(scene);
            st.show();
        }
        catch(Exception ex){
            System.out.println("blahhh");
        }
    }

}