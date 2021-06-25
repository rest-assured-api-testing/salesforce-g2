/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
 */
package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Campaign {

    private Attribute attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ParentId")
    private String parentId;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("ExpectedRevenue")
    private String expectedRevenue;
    @JsonProperty("BudgetedCost")
    private String budgetedCost;
    @JsonProperty("ActualCost")
    private String actualCost;
    @JsonProperty("ExpectedResponse")
    private Double expectedResponse;
    @JsonProperty("NumberSent")
    private Double numberSent;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("NumberOfLeads")
    private Integer numberOfLeads;
    @JsonProperty("NumberOfConvertedLeads")
    private Integer numberOfConvertedLeads;
    @JsonProperty("NumberOfContacts")
    private Integer numberOfContacts;
    @JsonProperty("NumberOfResponses")
    private Integer numberOfResponses;
    @JsonProperty("NumberOfOpportunities")
    private Integer numberOfOpportunities;
    @JsonProperty("NumberOfWonOpportunities")
    private Integer numberOfWonOpportunities;
    @JsonProperty("AmountAllOpportunities")
    private Double amountAllOpportunities;
    @JsonProperty("AmountWonOpportunities")
    private Double amountWonOpportunities;
    @JsonProperty("OwnerId")
    private String ownerId;
    @JsonProperty("CreatedDate")
    private Date createdDate;
    @JsonProperty("CreatedById")
    private String createdById;
    @JsonProperty("LastModifiedDate")
    private Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    private String lastModifiedById;
    @JsonProperty("SystemModstamp")
    private Date systemModstamp;
    @JsonProperty("LastActivityDate")
    private String lastActivityDate;
    @JsonProperty("LastViewedDate")
    private Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    private Date lastReferencedDate;
    @JsonProperty("CampaignMemberRecordTypeId")
    private String campaignMemberRecordTypeId;

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(final Attribute attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(final Boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    public String getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(final String expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public String getBudgetedCost() {
        return budgetedCost;
    }

    public void setBudgetedCost(final String budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public String getActualCost() {
        return actualCost;
    }

    public void setActualCost(final String actualCost) {
        this.actualCost = actualCost;
    }

    public Double getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(final Double expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public Double getNumberSent() {
        return numberSent;
    }

    public void setNumberSent(final Double numberSent) {
        this.numberSent = numberSent;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getNumberOfLeads() {
        return numberOfLeads;
    }

    public void setNumberOfLeads(final Integer numberOfLeads) {
        this.numberOfLeads = numberOfLeads;
    }

    public Integer getNumberOfConvertedLeads() {
        return numberOfConvertedLeads;
    }

    public void setNumberOfConvertedLeads(final Integer numberOfConvertedLeads) {
        this.numberOfConvertedLeads = numberOfConvertedLeads;
    }

    public Integer getNumberOfContacts() {
        return numberOfContacts;
    }

    public void setNumberOfContacts(final Integer numberOfContacts) {
        this.numberOfContacts = numberOfContacts;
    }

    public Integer getNumberOfResponses() {
        return numberOfResponses;
    }

    public void setNumberOfResponses(final Integer numberOfResponses) {
        this.numberOfResponses = numberOfResponses;
    }

    public Integer getNumberOfOpportunities() {
        return numberOfOpportunities;
    }

    public void setNumberOfOpportunities(final Integer numberOfOpportunities) {
        this.numberOfOpportunities = numberOfOpportunities;
    }

    public Integer getNumberOfWonOpportunities() {
        return numberOfWonOpportunities;
    }

    public void setNumberOfWonOpportunities(final Integer numberOfWonOpportunities) {
        this.numberOfWonOpportunities = numberOfWonOpportunities;
    }

    public Double getAmountAllOpportunities() {
        return amountAllOpportunities;
    }

    public void setAmountAllOpportunities(final Double amountAllOpportunities) {
        this.amountAllOpportunities = amountAllOpportunities;
    }

    public Double getAmountWonOpportunities() {
        return amountWonOpportunities;
    }

    public void setAmountWonOpportunities(final Double amountWonOpportunities) {
        this.amountWonOpportunities = amountWonOpportunities;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(final Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(final String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Date getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(final Date systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(final String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(final Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(final Date lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getCampaignMemberRecordTypeId() {
        return campaignMemberRecordTypeId;
    }

    public void setCampaignMemberRecordTypeId(final String campaignMemberRecordTypeId) {
        this.campaignMemberRecordTypeId = campaignMemberRecordTypeId;
    }
}
