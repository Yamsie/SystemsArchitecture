package ui.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TestWebPageController extends JFrame implements IController {
    //private TestWebPageView view;
    //private testwebpagemodel model; not implement
    private Button test;
    String str[] = {"google.com"};
    private JComboBox jcb = new JComboBox(str);
    private JLabel additionLabel = new JLabel("Please choose a website you want to test: ");
    private JButton button = new JButton("Submit");


    public TestWebPageController() {
        /*JPanel Panel1 = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Test Web Page");
        this.setVisible(true);
        this.setSize(600, 150);
        JPanel section1 = new JPanel(new BorderLayout());
        Panel1.add(additionLabel);
        Panel1.add(jcb);
        Panel1.add(button);
        section1.add(Panel1, BorderLayout.NORTH);
        setLayout(new GridLayout(1,1));
        add(section1);
        this.SubmitListener(new SubListener());*/
    }

    class SubListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent arg0) {
            String web = getWebChoosed();
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
            System.out.println("Exception caught in TestWebPageController changeScene()");
        }
    }

    public String getWebChoosed(){ return jcb.getActionCommand();}//not implement

    public void SubmitListener(ActionListener listenForButton) {
        button.addActionListener(listenForButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}