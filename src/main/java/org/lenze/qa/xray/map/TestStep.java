package org.lenze.qa.xray.map;

import java.util.ArrayList;

public class TestStep {
    public String action;
    public String data;
    public String result;
    public ArrayList<Attachment> attachments;

    public TestStep(String action, String data, String result, Attachment attachment) {
        this.action = action;
        this.data = data;
        this.result = result;

        this.attachments = new ArrayList<Attachment>();
        this.attachments.add(attachment);
    }

    public TestStep(String action, String data, String result) {
        this.action = action;
        this.data = data;
        this.result = result;
    }
}
