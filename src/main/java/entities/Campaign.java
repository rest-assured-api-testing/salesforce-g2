package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Campaign {

    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("ParentId")
    public String parentId;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("StartDate")
    public String startDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("ExpectedRevenue")
    public String expectedRevenue;
    @JsonProperty("BudgetedCost")
    public String budgetedCost;
    @JsonProperty("ActualCost")
    public String actualCost;
    @JsonProperty("ExpectedResponse")
    public Double expectedResponse;
    @JsonProperty("NumberSent")
    public Double numberSent;
    @JsonProperty("IsActive")
    public Boolean isActive;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("NumberOfLeads")
    public Integer numberOfLeads;
    @JsonProperty("NumberOfConvertedLeads")
    public Integer numberOfConvertedLeads;
    @JsonProperty("NumberOfContacts")
    public Integer numberOfContacts;
    @JsonProperty("NumberOfResponses")
    public Integer numberOfResponses;
    @JsonProperty("NumberOfOpportunities")
    public Integer numberOfOpportunities;
    @JsonProperty("NumberOfWonOpportunities")
    public Integer numberOfWonOpportunities;
    @JsonProperty("AmountAllOpportunities")
    public Double amountAllOpportunities;
    @JsonProperty("AmountWonOpportunities")
    public Double amountWonOpportunities;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("CreatedDate")
    public Date createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("SystemModstamp")
    public Date systemModstamp;
    @JsonProperty("LastActivityDate")
    public String lastActivityDate;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("CampaignMemberRecordTypeId")
    public String campaignMemberRecordTypeId;

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(String expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public String getBudgetedCost() {
        return budgetedCost;
    }

    public void setBudgetedCost(String budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public String getActualCost() {
        return actualCost;
    }

    public void setActualCost(String actualCost) {
        this.actualCost = actualCost;
    }

    public Double getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(Double expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public Double getNumberSent() {
        return numberSent;
    }

    public void setNumberSent(Double numberSent) {
        this.numberSent = numberSent;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfLeads() {
        return numberOfLeads;
    }

    public void setNumberOfLeads(Integer numberOfLeads) {
        this.numberOfLeads = numberOfLeads;
    }

    public Integer getNumberOfConvertedLeads() {
        return numberOfConvertedLeads;
    }

    public void setNumberOfConvertedLeads(Integer numberOfConvertedLeads) {
        this.numberOfConvertedLeads = numberOfConvertedLeads;
    }

    public Integer getNumberOfContacts() {
        return numberOfContacts;
    }

    public void setNumberOfContacts(Integer numberOfContacts) {
        this.numberOfContacts = numberOfContacts;
    }

    public Integer getNumberOfResponses() {
        return numberOfResponses;
    }

    public void setNumberOfResponses(Integer numberOfResponses) {
        this.numberOfResponses = numberOfResponses;
    }

    public Integer getNumberOfOpportunities() {
        return numberOfOpportunities;
    }

    public void setNumberOfOpportunities(Integer numberOfOpportunities) {
        this.numberOfOpportunities = numberOfOpportunities;
    }

    public Integer getNumberOfWonOpportunities() {
        return numberOfWonOpportunities;
    }

    public void setNumberOfWonOpportunities(Integer numberOfWonOpportunities) {
        this.numberOfWonOpportunities = numberOfWonOpportunities;
    }

    public Double getAmountAllOpportunities() {
        return amountAllOpportunities;
    }

    public void setAmountAllOpportunities(Double amountAllOpportunities) {
        this.amountAllOpportunities = amountAllOpportunities;
    }

    public Double getAmountWonOpportunities() {
        return amountWonOpportunities;
    }

    public void setAmountWonOpportunities(Double amountWonOpportunities) {
        this.amountWonOpportunities = amountWonOpportunities;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Date getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(Date systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(Date lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getCampaignMemberRecordTypeId() {
        return campaignMemberRecordTypeId;
    }

    public void setCampaignMemberRecordTypeId(String campaignMemberRecordTypeId) {
        this.campaignMemberRecordTypeId = campaignMemberRecordTypeId;
    }
}
