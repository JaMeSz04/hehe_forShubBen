package com.example.patipon.javaprojectuitest4;

/**
 * Created by Patipon on 11/15/2015.
 */
public class Notification {
    private String header;
    private String context;
    public Notification(String header, String context)
    {
        this.header = header;
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
