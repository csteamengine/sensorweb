package com.se491.sensorweb.Entity;

public class EchoRequest {
    private boolean isValidJson;
    private String text;

    public EchoRequest(boolean isValidJson, String text){
        this.isValidJson = isValidJson;
        this.text = text;
    }

    public boolean isValidJson() {
        return isValidJson;
    }

    public void setValidJson(boolean validJson) {
        isValidJson = validJson;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "EchoRequest{" +
                "isValidJson=" + isValidJson +
                ", text='" + text + '\'' +
                '}';
    }

    public String toStringForHtml(){
        return "<p>Is Valid Json: <strong>" + isValidJson + "</strong><br>" +
                "Text Sent: " + text + "<br></p>";
    }
}
