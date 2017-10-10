package ui.controllers;

import javafx.scene.control.Button;
import ui.views.TestWebPageView;

import java.awt.event.ActionListener;

public class TestWebPageController {
    private TestWebPageView view;
    //private testwebpagemodel model; not implement
    private Button test;

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
}