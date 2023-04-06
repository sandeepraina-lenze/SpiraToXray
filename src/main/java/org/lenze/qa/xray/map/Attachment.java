package org.lenze.qa.xray.map;

public class Attachment {
    public String filename;
    public String mimeType;
    public String data;

    public Attachment(String filename, String mimeType, String data) {
        this.filename = filename;
        this.mimeType = mimeType;
        this.data = data;
    }
}
