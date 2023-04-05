package org.lenze.qa.spira.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project{
    @SerializedName("LastOpenedForUser")
    public String lastOpenedForUser;
    @SerializedName("CreationDate")
    public String creationDate;
    @SerializedName("IsReqStatusByTasks")
    public boolean isReqStatusByTasks;
    @SerializedName("ArtifactId")
    public int artifactId;
    @SerializedName("Requirements")
    public String requirements;
    @SerializedName("Name")
    public String name;
    @SerializedName("Components")
    public String components;
    @SerializedName("Item")
    public String item;
    @SerializedName("ReqPointEffort")
    public int reqPointEffort;
    @SerializedName("WorkingDays")
    public int workingDays;
    @SerializedName("ArtifactToken")
    public String artifactToken;
    @SerializedName("Tasks")
    public String tasks;
    @SerializedName("ArtifactPrefix")
    public String artifactPrefix;
    @SerializedName("Builds")
    public String builds;
    @SerializedName("Workflows")
    public String workflows;
    @SerializedName("SettingsEntries")
    public String settingsEntries;
    @SerializedName("CustomPropertyLists")
    public String customPropertyLists;
    @SerializedName("TaskDefaultEffort")
    public String taskDefaultEffort;
    @SerializedName("IsReqStatusByTestCases")
    public boolean isReqStatusByTestCases;
    @SerializedName("TaraVault")
    public String taraVault;
    @SerializedName("IncidentTypes")
    public String incidentTypes;
    @SerializedName("ArtifactCustomProperties")
    public String artifactCustomProperties;
    @SerializedName("Placeholders")
    public String placeholders;
    @SerializedName("IncidentStatuses")
    public String incidentStatuses;
    @SerializedName("IncidentPriorities")
    public String incidentPriorities;
    @SerializedName("IsEffortTestCases")
    public boolean isEffortTestCases;
    @SerializedName("Group")
    public String group;
    @SerializedName("TaskTypeWorkflows")
    public String taskTypeWorkflows;
    @SerializedName("Description")
    public String description;
    @SerializedName("IsActive")
    public boolean isActive;
    @SerializedName("IsTimeTrackTasks")
    public boolean isTimeTrackTasks;
    @SerializedName("Website")
    public String website;
    @SerializedName("IsTimeTrackIncidents")
    public boolean isTimeTrackIncidents;
    @SerializedName("Properties")
    public String properties;
    @SerializedName("SavedFilters")
    public String savedFilters;
    @SerializedName("ProjectGroupId")
    public int projectGroupId;
    @SerializedName("VersionControlProjects")
    public String versionControlProjects;
    @SerializedName("RequirementTypeWorkflows")
    public String requirementTypeWorkflows;
    @SerializedName("IncidentSeverities")
    public String incidentSeverities;
    @SerializedName("IsEffortIncidents")
    public boolean isEffortIncidents;
    @SerializedName("ReqDefaultEstimate")
    public int reqDefaultEstimate;
    @SerializedName("TaskFolders")
    public String taskFolders;
    @SerializedName("SavedReports")
    public String savedReports;
    @SerializedName("CustomProperties")
    public String customProperties;
    @SerializedName("TaskWorkflows")
    public String taskWorkflows;
    @SerializedName("UserFields")
    public String userFields;
    @SerializedName("IsTasksAutoCreate")
    public boolean isTasksAutoCreate;
    @SerializedName("IsEffortTasks")
    public boolean isEffortTasks;
    @SerializedName("ProjectId")
    public int projectId;
    @SerializedName("EntityChangeTracker")
    public String entityChangeTracker;
    @SerializedName("Incidents")
    public String incidents;
    @SerializedName("RequirementWorkflows")
    public String requirementWorkflows;
    @SerializedName("ChangeTracker")
    public String changeTracker;
    @SerializedName("WorkingHours")
    public int workingHours;
    @SerializedName("NonWorkingHours")
    public int nonWorkingHours;
    @SerializedName("IsReqStatusAutoPlanned")
    public boolean isReqStatusAutoPlanned;
    @SerializedName("ArtifactType")
    public String artifactType;
    @SerializedName("UserCustomProperties")
    public String userCustomProperties;
    @SerializedName("UserMembership")
    public String userMembership;
}
