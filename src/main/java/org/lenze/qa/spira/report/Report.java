package org.lenze.qa.spira.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Report{
    @SerializedName("TestCaseData")
    public TestCaseData testCaseData;
    @SerializedName("Title")
    public String Title;
    @SerializedName("ProjectData")
    public ProjectData projectData;
}