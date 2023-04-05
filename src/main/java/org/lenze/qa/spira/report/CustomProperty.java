package org.lenze.qa.spira.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomProperty{
    @SerializedName("Type")
    public String type;
    @SerializedName("Alias")
    public String alias;
    @SerializedName("Name")
    public String name;
}