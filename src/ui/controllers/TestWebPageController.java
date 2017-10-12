package ui.controllers;

import javafx.scene.control.Button;
import ui.views.I_View;
import ui.views.TestWebPageView;

import java.awt.event.ActionListener;

public class TestWebPageController implements Command{
    private TestWebPageView view;
    //private testwebpagemodel model; not implement
    private Button test;
    public String name = "TestWebPageController";

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

    public I_View execute(){
        return new TestWebPageView();
    }
}