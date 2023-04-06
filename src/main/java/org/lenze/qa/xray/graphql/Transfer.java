package org.lenze.qa.xray.graphql;

import com.google.gson.Gson;
import org.lenze.qa.spira.report.TestCase;
import org.lenze.qa.xray.map.Attachment;
import org.lenze.qa.xray.map.CreateTest;
import org.lenze.qa.xray.map.TestStep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Transfer {

    public String FromSpira(TestCase testCase) {
        CreateTest createTest = new CreateTest();

        createTest.testType.name = "Manual";

        String summary = testCase.name.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");

        for (org.lenze.qa.spira.report.TestStep testStep : testCase.testSteps.testStep) {
            String s1 = testStep.description;
            String s2 = testStep.sampleData;
            String s3 = testStep.expectedResult;
            String attachmentSrc = "";

            if (s3.contains("<img")) {
                Pattern p = Pattern.compile(".*<img[^>]*src=\"([^\"]*)", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(s3);

                while (m.find()) {
                    attachmentSrc = m.group(1).replaceAll("data:image/png;base64,", "");
                }

                s1 = s1.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");
                s2 = s2.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");
                s3 = s3.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");

                createTest.steps.add(new TestStep(s1, s2, s3, new Attachment("sample.png", "image/png", attachmentSrc)));
            }
            else {
                s1 = s1.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");
                s2 = s2.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");
                s3 = s3.replaceAll("\\<.*?\\>", "").replaceAll("&nbsp;", "");

                createTest.steps.add(new TestStep(s1, s2, s3));
            }
        }

        createTest.jira.fields.project.key = "XS";
        createTest.jira.fields.summary = summary;

        Gson gson = new Gson();
        String createTestData = gson.toJson(createTest);

        createTestData = createTestData.replaceAll("\\{\"", "{").replaceAll("\":", ":").replaceAll(",\"", ",");

        createTestData = "createTest( " + createTestData.substring(1, createTestData.length()-1) + " ) { ";
        createTestData = createTestData + " test { ";
        createTestData = createTestData + " issueId ";
        createTestData = createTestData + " testType { ";
        createTestData = createTestData + " name ";
        createTestData = createTestData + " } ";
        createTestData = createTestData + " steps { ";
        createTestData = createTestData + " action ";
        createTestData = createTestData + " data ";
        createTestData = createTestData + " result ";
        createTestData = createTestData + " } ";
        createTestData = createTestData + " jira(fields: [\"key\"]) ";
        createTestData = createTestData + " } ";
        createTestData = createTestData + " warnings ";
        createTestData = createTestData + " } ";
        createTestData = "mutation { " + createTestData + " } ";

        return createTestData;
    }
}
