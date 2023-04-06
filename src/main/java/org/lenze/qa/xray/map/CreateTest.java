package org.lenze.qa.xray.map;

import java.util.ArrayList;

public class CreateTest {
    public TestType testType;
    public ArrayList<TestStep> steps;
    public Jira jira;

    public CreateTest() {
        this.testType = new TestType();
        this.jira = new Jira();
        this.steps = new ArrayList<TestStep>();
    }
}
