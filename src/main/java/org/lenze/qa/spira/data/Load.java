package org.lenze.qa.spira.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import org.json.XML;
import org.lenze.qa.spira.report.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URL;

public class Load {
    public void fromXML() {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            StreamSource reportStream = new StreamSource(new URL("file:///C:/Users/raina/Desktop/Generated.xml").openStream());
            XMLStreamReader spiraReportReader = factory.createXMLStreamReader(reportStream);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new StAXSource(spiraReportReader), new StreamResult(stringWriter));

            JSONObject json = XML.toJSONObject(stringWriter.toString());

            Gson gson = new Gson();
            Root report = gson.fromJson(json.toString(4), (new TypeToken<Root>() {}).getType());

            System.out.println(report);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}