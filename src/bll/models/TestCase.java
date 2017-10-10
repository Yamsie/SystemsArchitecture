package bll.models;

public class TestCase {
    //1,google.com,textBox,"Test Google Search","hello"
    private int id;
    private String url;
    private String textBox;
    private String input;
    private String name;

    public TestCase(int id, String url, String textBox, String input, String name) {
        this.id = id;
        this.url = url;
        this.textBox = textBox;
        this.input = input;
        this.name = name;
    }

    public TestCase(String[] data) {
        this.id = Integer.parseInt(data[0]);
        this.url = data[1];
        this.textBox = data[2];
        this.input = data[3];
        this.name = data[4];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTextBox() {
        return textBox;
    }

    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
