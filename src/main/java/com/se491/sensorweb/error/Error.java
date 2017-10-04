package com.se491.sensorweb.error;

public class Error {
    private String error;
    private String input;

    public Error(){

    }

    public Error(String error, String input) {
        this.error = error;
        this.input = input;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }


}
