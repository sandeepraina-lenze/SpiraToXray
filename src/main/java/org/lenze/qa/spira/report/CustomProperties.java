package org.lenze.qa.spira.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomProperties{
    @SerializedName("CustomProperty")
    public ArrayList<CustomProperty> customProperty;
}
