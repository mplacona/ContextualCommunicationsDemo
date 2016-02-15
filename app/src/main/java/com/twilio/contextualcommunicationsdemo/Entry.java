package com.twilio.contextualcommunicationsdemo;

/**
 * Created by mplacona on 08/02/2016.
 */
public class Entry {

    private String label;
    private String value;
    public Entry() {

    }

    public Entry(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
