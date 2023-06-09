package org.lenze.qa.spira.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import org.json.XML;
import org.lenze.qa.properties.XRayProperties;
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
    public TestCaseData fromXML() {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            StreamSource reportStream = new StreamSource(new URL(XRayProperties.spiraXMLFile).openStream());
            XMLStreamReader spiraReportReader = factory.createXMLStreamReader(reportStream);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new StAXSource(spiraReportReader), new StreamResult(stringWriter));

            String xmlData = stringWriter.toString();
            xmlData = xmlData.replaceAll("</TestStep></TestSteps>", "</TestStep><TestStep /></TestSteps>");

            JSONObject json = XML.toJSONObject(xmlData);


            String spiraData = json.toString(4).replaceAll("\"TestSteps\": \"\"", "\"TestSteps\": null").replaceAll("\"CustomProperties\": \"\"", "\"CustomProperties\": null");

            spiraData = spiraData.replaceAll("},\n" +
                    "                \"\"\n" +
                    "            ]", "}\n" +
                    "            ]");

            Gson gson = new Gson();
            Root report = gson.fromJson(spiraData, (new TypeToken<Root>() {}).getType());

            return report.report.testCaseData;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
