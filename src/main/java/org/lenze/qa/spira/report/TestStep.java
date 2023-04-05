package org.lenze.qa.spira.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestStep {
    @SerializedName("TestStepId")
    public String testStepID;
    @SerializedName("TestCaseId")
    public String testCaseID;
    @SerializedName("ExecutionStatusId")
    public String executionStatusID;
    @SerializedName("Description")
    public String description;
    @SerializedName("Position")
    public String position;
    @SerializedName("ExpectedResult")
    public String expectedResult;
    @SerializedName("SampleData")
    public String sampleData;
    @SerializedName("LinkedTestCaseId")
    public String linkedTestCaseID;
    @SerializedName("AttachmentsYn")
    public String attachmentsYn;
    @SerializedName("LastUpdateDate")
    public String lastUpdateDate;
    @SerializedName("ExecutionStatusName")
    public String executionStatusName;
    @SerializedName("LinkedTestCaseName")
    public String linkedTestCaseName;
    @SerializedName("Custom_01")
    public String custom01;
    @SerializedName("Custom_02")
    public String custom02;
    @SerializedName("Custom_03")
    public String custom03;
    @SerializedName("Custom_04")
    public String custom04;
    @SerializedName("Custom_05")
    public String custom05;
    @SerializedName("Custom_06")
    public String custom06;
    @SerializedName("Custom_07")
    public String custom07;
    @SerializedName("Custom_08")
    public String custom08;
    @SerializedName("Custom_09")
    public String custom09;
    @SerializedName("Custom_10")
    public String custom10;
    @SerializedName("Custom_11")
    public String custom11;
    @SerializedName("Custom_12")
    public String custom12;
    @SerializedName("Custom_13")
    public String custom13;
    @SerializedName("Custom_14")
    public String custom14;
    @SerializedName("Custom_15")
    public String custom15;
    @SerializedName("Custom_16")
    public String custom16;
    @SerializedName("Custom_17")
    public String custom17;
    @SerializedName("Custom_18")
    public String custom18;
    @SerializedName("Custom_19")
    public String custom19;
    @SerializedName("Custom_20")
    public String custom20;
    @SerializedName("Custom_21")
    public String custom21;
    @SerializedName("Custom_22")
    public String custom22;
    @SerializedName("Custom_23")
    public String custom23;
    @SerializedName("Custom_24")
    public String custom24;
    @SerializedName("Custom_25")
    public String custom25;
    @SerializedName("Custom_26")
    public String custom26;
    @SerializedName("Custom_27")
    public String custom27;
    @SerializedName("Custom_28")
    public String custom28;
    @SerializedName("Custom_29")
    public String custom29;
    @SerializedName("Custom_30")
    public String custom30;
    @SerializedName("IS_DELETED")
    public String isDeleted;
}
