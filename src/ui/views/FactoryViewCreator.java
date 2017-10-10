package ui.views;

public class FactoryViewCreator {

    public I_View createView(String name) {
        I_View view = null;
        try {
            //if (view == "mainWindow") {
            //return new MainWindowView();
            //}
            if (name == "TestWebParseView") {
                view = new TestWebParserView();
            } else if (name == "NewTestScenario") {
                view = new NewTestScenarioView();
            }
        } catch (Exception ex) {
            System.out.println("There has been an error.");
        }
        return view;
    }
}
