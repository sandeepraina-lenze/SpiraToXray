package org.lenze.qa;

import org.lenze.qa.properties.XRayProperties;
import org.lenze.qa.spira.data.Load;
import org.lenze.qa.spira.report.TestCase;
import org.lenze.qa.spira.report.TestCaseData;
import org.lenze.qa.spira.report.TestSteps;
import org.lenze.qa.xray.graphql.Execute;
import org.lenze.qa.xray.graphql.Token;
import org.lenze.qa.xray.graphql.Transfer;

public class Migrate {
    public static void main(String[] args) {
        TestCaseData spiraTestCaseData = (new Load()).fromXML();

        (new Token()).Generate(XRayProperties.clientID, XRayProperties.clientSecret);

        //XRay cloud client ID and Secret needs to be created manually in the system
        //If JIRA is installed and mainatined locally as a server in the organization then use RestAPI calls instead of graphql
        //Before initialing transfer add a code to Authenticate the XRay cloud with client ID and Secret to generate a token which remains live for 24 hrs

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
