/*package ui.views;

import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TestWebPageView extends JFrame{
    String str[] = {"google.com"};
    private JComboBox jcb = new JComboBox(str);
    private JLabel additionLabel = new JLabel("Please choose a website you want to test: ");
    private JButton button = new JButton("Submit");

    public TestWebPageView(){
        JPanel Panel1 = new JPanel();
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
    }

    public String getWebChoosed(){ return jcb.getActionCommand();}//not implement

    public void SubmitListener(ActionListener listenForButton) {
        button.addActionListener(listenForButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void runView(Stage st){ }
}
*/