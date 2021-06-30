/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    private Attribute attributes;
    private String id;
    private String ownerId;
    private Boolean isDeleted;
    private String lastName;
    private String firstName;
    private String salutation;
    private String name;
    private Boolean hasOptedOutTracking;
    private Boolean hasOptedOutProfiling;
    private Boolean hasOptedOutProcessing;
    private Boolean hasOptedOutSolicit;
    private Boolean shouldForget;
    private Boolean sendIndividualData;
    private Boolean canStorePiiElsewhere;
    private Boolean hasOptedOutGeoTracking;
    private String birthDate;
    private String deathDate;
    private String convictionsCount;
    private String childrenCount;
    private String militaryService;
    private Boolean isHomeOwner;
    private String occupation;
    private String website;
    private String individualsAge;
    private String lastViewedDate;
    private String masterRecordId;
    private String consumerCreditScore;
    private String consumerCreditScoreProviderName;
    private String influencerRating;
    private String createdDate;
    private String createdById;
    private String lastModifiedDate;
    private String lastModifiedById;
    private String systemModstamp;

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(final Attribute attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(final String id) {
        this.id = id;
    }

    @JsonProperty("OwnerId")
    public String getOwnerId() {
        return ownerId;
    }

    @JsonProperty("OwnerId")
    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    @JsonProperty("IsDeleted")
    public Boolean isDeleted() {
        return isDeleted;
    }

    @JsonProperty("IsDeleted")
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("Salutation")
    public String getSalutation() {
        return salutation;
    }

    @JsonProperty("Salutation")
    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(final String name) {
        this.name = name;
    }

    @JsonProperty("HasOptedOutTracking")
    public Boolean isHasOptedOutTracking() {
        return hasOptedOutTracking;
    }

    @JsonProperty("HasOptedOutTracking")
    public void setHasOptedOutTracking(boolean hasOptedOutTracking) {
        this.hasOptedOutTracking = hasOptedOutTracking;
    }

    @JsonProperty("HasOptedOutProfiling")
    public Boolean isHasOptedOutProfiling() {
        return hasOptedOutProfiling;
    }

    @JsonProperty("HasOptedOutProfiling")
    public void setHasOptedOutProfiling(boolean hasOptedOutProfiling) {
        this.hasOptedOutProfiling = hasOptedOutProfiling;
    }

    @JsonProperty("HasOptedOutProcessing")
    public Boolean isHasOptedOutProcessing() {
        return hasOptedOutProcessing;
    }

    @JsonProperty("HasOptedOutProcessing")
    public void setHasOptedOutProcessing(boolean hasOptedOutProcessing) {
        this.hasOptedOutProcessing = hasOptedOutProcessing;
    }

    @JsonProperty("HasOptedOutSolicit")
    public Boolean isHasOptedOutSolicit() {
        return hasOptedOutSolicit;
    }

    @JsonProperty("HasOptedOutSolicit")
    public void setHasOptedOutSolicit(boolean hasOptedOutSolicit) {
        this.hasOptedOutSolicit = hasOptedOutSolicit;
    }

    @JsonProperty("ShouldForget")
    public Boolean isShouldForget() {
        return shouldForget;
    }

    @JsonProperty("ShouldForget")
    public void setShouldForget(boolean shouldForget) {
        this.shouldForget = shouldForget;
    }

    @JsonProperty("SendIndividualData")
    public Boolean isSendIndividualData() {
        return sendIndividualData;
    }

    @JsonProperty("SendIndividualData")
    public void setSendIndividualData(boolean sendIndividualData) {
        this.sendIndividualData = sendIndividualData;
    }

    @JsonProperty("CanStorePiiElsewhere")
    public Boolean isCanStorePiiElsewhere() {
        return canStorePiiElsewhere;
    }

    @JsonProperty("CanStorePiiElsewhere")
    public void setCanStorePiiElsewhere(boolean canStorePiiElsewhere) {
        this.canStorePiiElsewhere = canStorePiiElsewhere;
    }

    @JsonProperty("HasOptedOutGeoTracking")
    public Boolean isHasOptedOutGeoTracking() {
        return hasOptedOutGeoTracking;
    }

    @JsonProperty("HasOptedOutGeoTracking")
    public void setHasOptedOutGeoTracking(boolean hasOptedOutGeoTracking) {
        this.hasOptedOutGeoTracking = hasOptedOutGeoTracking;
    }

    @JsonProperty("BirthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("BirthDate")
    public void setBirthDate(final String birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("DeathDate")
    public String getDeathDate() {
        return deathDate;
    }

    @JsonProperty("DeathDate")
    public void setDeathDate(final String deathDate) {
        this.deathDate = deathDate;
    }

    @JsonProperty("ConvictionsCount")
    public String getConvictionsCount() {
        return convictionsCount;
    }

    @JsonProperty("ConvictionsCount")
    public void setConvictionsCount(final String convictionsCount) {
        this.convictionsCount = convictionsCount;
    }

    @JsonProperty("ChildrenCount")
    public String getChildrenCount() {
        return childrenCount;
    }

    @JsonProperty("ChildrenCount")
    public void setChildrenCount(final String childrenCount) {
        this.childrenCount = childrenCount;
    }

    @JsonProperty("MilitaryService")
    public String getMilitaryService() {
        return militaryService;
    }

    @JsonProperty("MilitaryService")
    public void setMilitaryService(final String militaryService) {
        this.militaryService = militaryService;
    }

    @JsonProperty("IsHomeOwner")
    public Boolean isHomeOwner() {
        return isHomeOwner;
    }

    @JsonProperty("IsHomeOwner")
    public void setHomeOwner(boolean homeOwner) {
        isHomeOwner = homeOwner;
    }

    @JsonProperty("Occupation")
    public String getOccupation() {
        return occupation;
    }

    @JsonProperty("Occupation")
    public void setOccupation(final String occupation) {
        this.occupation = occupation;
    }

    @JsonProperty("Website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("Website")
    public void setWebsite(final String website) {
        this.website = website;
    }

    @JsonProperty("IndividualsAge")
    public String getIndividualsAge() {
        return individualsAge;
    }

    @JsonProperty("IndividualsAge")
    public void setIndividualsAge(final String individualsAge) {
        this.individualsAge = individualsAge;
    }

    @JsonProperty("LastViewedDate")
    public String getLastViewedDate() {
        return lastViewedDate;
    }

    @JsonProperty("LastViewedDate")
    public void setLastViewedDate(final String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    @JsonProperty("MasterRecordId")
    public String getMasterRecordId() {
        return masterRecordId;
    }

    @JsonProperty("MasterRecordId")
    public void setMasterRecordId(final String masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    @JsonProperty("ConsumerCreditScore")
    public String getConsumerCreditScore() {
        return consumerCreditScore;
    }

    @JsonProperty("ConsumerCreditScore")
    public void setConsumerCreditScore(final String consumerCreditScore) {
        this.consumerCreditScore = consumerCreditScore;
    }

    @JsonProperty("ConsumerCreditScoreProviderName")
    public String getConsumerCreditScoreProviderName() {
        return consumerCreditScoreProviderName;
    }

    @JsonProperty("ConsumerCreditScoreProviderName")
    public void setConsumerCreditScoreProviderName(final String consumerCreditScoreProviderName) {
        this.consumerCreditScoreProviderName = consumerCreditScoreProviderName;
    }

    @JsonProperty("InfluencerRating")
    public String getInfluencerRating() {
        return influencerRating;
    }

    @JsonProperty("InfluencerRating")
    public void setInfluencerRating(final String influencerRating) {
        this.influencerRating = influencerRating;
    }

    @JsonProperty("CreatedDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("CreatedDate")
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("CreatedById")
    public String getCreatedById() {
        return createdById;
    }

    @JsonProperty("CreatedById")
    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    @JsonProperty("LastModifiedDate")
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    @JsonProperty("LastModifiedDate")
    public void setLastModifiedDate(final String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @JsonProperty("LastModifiedById")
    public String getLastModifiedById() {
        return lastModifiedById;
    }

    @JsonProperty("LastModifiedById")
    public void setLastModifiedById(final String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    @JsonProperty("SystemModstamp")
    public String getSystemModstamp() {
        return systemModstamp;
    }

    @JsonProperty("SystemModstamp")
    public void setSystemModstamp(final String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }
}
