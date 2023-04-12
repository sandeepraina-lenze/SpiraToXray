package org.lenze.qa;

import org.lenze.qa.properties.XRayProperties;
import org.lenze.qa.spira.data.Load;
import org.lenze.qa.spira.report.TestCase;
import org.lenze.qa.spira.report.TestCaseData;
import org.lenze.qa.spira.report.TestSteps;
import org.lenze.qa.xray.graphql.Execute;
import org.lenze.qa.xray.graphql.Token;
import org.lenze.qa.xray.graphql.Transfer;

import static java.lang.System.exit;

public class Migrate {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Please enter the arguments");
            exit(1);
        }

        XRayProperties.jiraProjectKey = args[0];
        XRayProperties.clientID = args[1];
        XRayProperties.clientSecret = args[2];
        XRayProperties.spiraXMLFile = args[3];

        TestCaseData spiraTestCaseData = (new Load()).fromXML();
        (new Token()).Generate(XRayProperties.clientID, XRayProperties.clientSecret);

        //XRay cloud client ID and Secret needs to be created manually in the system
        //If JIRA is installed and mainatined locally as a server in the organization then use RestAPI calls instead of graphql

        for(TestCase testCase : spiraTestCaseData.testCase) {
           if (testCase.testSteps != null) {
               TestSteps steps = testCase.testSteps;
               System.out.println(steps.testStep.size());

               String mutuationQuery = (new Transfer()).FromSpira(testCase);
               (new Execute()).Migrate(mutuationQuery);
           }
        }


    }
}
