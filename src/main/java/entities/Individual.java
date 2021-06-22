package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Individual {

    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("IsDeleted")
    public boolean isDeleted;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("Salutation")
    public String salutation;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("HasOptedOutTracking")
    public boolean hasOptedOutTracking;
    @JsonProperty("HasOptedOutProfiling")
    public boolean hasOptedOutProfiling;
    @JsonProperty("HasOptedOutProcessing")
    public boolean hasOptedOutProcessing;
    @JsonProperty("HasOptedOutSolicit")
    public boolean hasOptedOutSolicit;
    @JsonProperty("ShouldForget")
    public boolean shouldForget;
    @JsonProperty("SendIndividualData")
    public boolean sendIndividualData;
    @JsonProperty("CanStorePiiElsewhere")
    public boolean canStorePiiElsewhere;
    @JsonProperty("HasOptedOutGeoTracking")
    public boolean hasOptedOutGeoTracking;
    @JsonProperty("BirthDate")
    public String birthDate;
    @JsonProperty("DeathDate")
    public String deathDate;
    @JsonProperty("ConvictionsCount")
    public String convictionsCount;
    @JsonProperty("ChildrenCount")
    public String childrenCount;
    @JsonProperty("MilitaryService")
    public String militaryService;
    @JsonProperty("IsHomeOwner")
    public boolean isHomeOwner;
    @JsonProperty("Occupation")
    public String occupation;
    @JsonProperty("Website")
    public String website;
    @JsonProperty("IndividualsAge")
    public String individualsAge;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("MasterRecordId")
    public String masterRecordId;
    @JsonProperty("ConsumerCreditScore")
    public String consumerCreditScore;
    @JsonProperty("ConsumerCreditScoreProviderName")
    public String consumerCreditScoreProviderName;
    @JsonProperty("InfluencerRating")
    public String influencerRating;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasOptedOutTracking() {
        return hasOptedOutTracking;
    }

    public void setHasOptedOutTracking(boolean hasOptedOutTracking) {
        this.hasOptedOutTracking = hasOptedOutTracking;
    }

    public boolean isHasOptedOutProfiling() {
        return hasOptedOutProfiling;
    }

    public void setHasOptedOutProfiling(boolean hasOptedOutProfiling) {
        this.hasOptedOutProfiling = hasOptedOutProfiling;
    }

    public boolean isHasOptedOutProcessing() {
        return hasOptedOutProcessing;
    }

    public void setHasOptedOutProcessing(boolean hasOptedOutProcessing) {
        this.hasOptedOutProcessing = hasOptedOutProcessing;
    }

    public boolean isHasOptedOutSolicit() {
        return hasOptedOutSolicit;
    }

    public void setHasOptedOutSolicit(boolean hasOptedOutSolicit) {
        this.hasOptedOutSolicit = hasOptedOutSolicit;
    }

    public boolean isShouldForget() {
        return shouldForget;
    }

    public void setShouldForget(boolean shouldForget) {
        this.shouldForget = shouldForget;
    }

    public boolean isSendIndividualData() {
        return sendIndividualData;
    }

    public void setSendIndividualData(boolean sendIndividualData) {
        this.sendIndividualData = sendIndividualData;
    }

    public boolean isCanStorePiiElsewhere() {
        return canStorePiiElsewhere;
    }

    public void setCanStorePiiElsewhere(boolean canStorePiiElsewhere) {
        this.canStorePiiElsewhere = canStorePiiElsewhere;
    }

    public boolean isHasOptedOutGeoTracking() {
        return hasOptedOutGeoTracking;
    }

    public void setHasOptedOutGeoTracking(boolean hasOptedOutGeoTracking) {
        this.hasOptedOutGeoTracking = hasOptedOutGeoTracking;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getConvictionsCount() {
        return convictionsCount;
    }

    public void setConvictionsCount(String convictionsCount) {
        this.convictionsCount = convictionsCount;
    }

    public String getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(String childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getMilitaryService() {
        return militaryService;
    }

    public void setMilitaryService(String militaryService) {
        this.militaryService = militaryService;
    }

    public boolean isHomeOwner() {
        return isHomeOwner;
    }

    public void setHomeOwner(boolean homeOwner) {
        isHomeOwner = homeOwner;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIndividualsAge() {
        return individualsAge;
    }

    public void setIndividualsAge(String individualsAge) {
        this.individualsAge = individualsAge;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getMasterRecordId() {
        return masterRecordId;
    }

    public void setMasterRecordId(String masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    public String getConsumerCreditScore() {
        return consumerCreditScore;
    }

    public void setConsumerCreditScore(String consumerCreditScore) {
        this.consumerCreditScore = consumerCreditScore;
    }

    public String getConsumerCreditScoreProviderName() {
        return consumerCreditScoreProviderName;
    }

    public void setConsumerCreditScoreProviderName(String consumerCreditScoreProviderName) {
        this.consumerCreditScoreProviderName = consumerCreditScoreProviderName;
    }

    public String getInfluencerRating() {
        return influencerRating;
    }

    public void setInfluencerRating(String influencerRating) {
        this.influencerRating = influencerRating;
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
}
