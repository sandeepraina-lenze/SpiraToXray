package org.lenze.qa.properties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XRayProperties {
    public static String clientID;
    public static String clientSecret;
    public static String xrayToken;
    public static String jiraProjectKey;
    public static String spiraXMLFile;
    public static FileWriter writeLog;

    static {
        try {
            writeLog = new FileWriter(new File("Migration.log"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
