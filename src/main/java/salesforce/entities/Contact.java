package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {

    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("MasterRecordId")
    public String masterRecordId;
    @JsonProperty("AccountId")
    public String accountId;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("Salutation")
    public String salutation;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("OtherStreet")
    public String otherStreet;
    @JsonProperty("OtherCity")
    public String otherCity;
    @JsonProperty("OtherState")
    public String otherState;
    @JsonProperty("OtherPostalCode")
    public String otherPostalCode;
    @JsonProperty("OtherCountry")
    public String otherCountry;
    @JsonProperty("OtherLatitude")
    public String otherLatitude;
    @JsonProperty("OtherLongitude")
    public String otherLongitude;
    @JsonProperty("OtherGeocodeAccuracy")
    public String otherGeocodeAccuracy;
    @JsonProperty("OtherAddress")
    public String otherAddress;
    @JsonProperty("MailingStreet")
    public String mailingStreet;
    @JsonProperty("MailingCity")
    public String mailingCity;
    @JsonProperty("MailingState")
    public String mailingState;
    @JsonProperty("MailingPostalCode")
    public String mailingPostalCode;
    @JsonProperty("MailingCountry")
    public String mailingCountry;
    @JsonProperty("MailingLatitude")
    public String mailingLatitude;
    @JsonProperty("MailingLongitude")
    public String mailingLongitude;
    @JsonProperty("MailingGeocodeAccuracy")
    public String mailingGeocodeAccuracy;
    @JsonProperty("MailingAddress")
    public String mailingAddress;
    @JsonProperty("Phone")
    public String phone;
    @JsonProperty("Fax")
    public String fax;
    @JsonProperty("MobilePhone")
    public String mobilePhone;
    @JsonProperty("HomePhone")
    public String homePhone;
    @JsonProperty("OtherPhone")
    public String otherPhone;
    @JsonProperty("AssistantPhone")
    public String assistantPhone;
    @JsonProperty("ReportsToId")
    public String reportsToId;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Department")
    public String department;
    @JsonProperty("AssistantName")
    public String assistantName;
    @JsonProperty("LeadSource")
    public String leadSource;
    @JsonProperty("Birthdate")
    public String birthdate;
    @JsonProperty("Description")
    public String description;
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
    @JsonProperty("LastCURequestDate")
    public String lastCURequestDate;
    @JsonProperty("LastCUUpdateDate")
    public String lastCUUpdateDate;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("EmailBouncedReason")
    public String emailBouncedReason;
    @JsonProperty("EmailBouncedDate")
    public String emailBouncedDate;
    @JsonProperty("IsEmailBounced")
    public Boolean isEmailBounced;
    @JsonProperty("PhotoUrl")
    public String photoUrl;
    @JsonProperty("Jigsaw")
    public String jigsaw;
    @JsonProperty("JigsawContactId")
    public String jigsawContactId;
    @JsonProperty("CleanStatus")
    public String cleanStatus;
    @JsonProperty("IndividualId")
    public String individualId;
    @JsonProperty("Level__c")
    public String level__c;
    @JsonProperty("Languages__c")
    public String languages__c;

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

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getMasterRecordId() {
        return masterRecordId;
    }

    public void setMasterRecordId(String masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getOtherStreet() {
        return otherStreet;
    }

    public void setOtherStreet(String otherStreet) {
        this.otherStreet = otherStreet;
    }

    public String getOtherCity() {
        return otherCity;
    }

    public void setOtherCity(String otherCity) {
        this.otherCity = otherCity;
    }

    public String getOtherState() {
        return otherState;
    }

    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    public String getOtherPostalCode() {
        return otherPostalCode;
    }

    public void setOtherPostalCode(String otherPostalCode) {
        this.otherPostalCode = otherPostalCode;
    }

    public String getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }

    public String getOtherLatitude() {
        return otherLatitude;
    }

    public void setOtherLatitude(String otherLatitude) {
        this.otherLatitude = otherLatitude;
    }

    public String getOtherLongitude() {
        return otherLongitude;
    }

    public void setOtherLongitude(String otherLongitude) {
        this.otherLongitude = otherLongitude;
    }

    public String getOtherGeocodeAccuracy() {
        return otherGeocodeAccuracy;
    }

    public void setOtherGeocodeAccuracy(String otherGeocodeAccuracy) {
        this.otherGeocodeAccuracy = otherGeocodeAccuracy;
    }

    public String getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(String otherAddress) {
        this.otherAddress = otherAddress;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingPostalCode() {
        return mailingPostalCode;
    }

    public void setMailingPostalCode(String mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public String getMailingLatitude() {
        return mailingLatitude;
    }

    public void setMailingLatitude(String mailingLatitude) {
        this.mailingLatitude = mailingLatitude;
    }

    public String getMailingLongitude() {
        return mailingLongitude;
    }

    public void setMailingLongitude(String mailingLongitude) {
        this.mailingLongitude = mailingLongitude;
    }

    public String getMailingGeocodeAccuracy() {
        return mailingGeocodeAccuracy;
    }

    public void setMailingGeocodeAccuracy(String mailingGeocodeAccuracy) {
        this.mailingGeocodeAccuracy = mailingGeocodeAccuracy;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }

    public void setAssistantPhone(String assistantPhone) {
        this.assistantPhone = assistantPhone;
    }

    public String getReportsToId() {
        return reportsToId;
    }

    public void setReportsToId(String reportsToId) {
        this.reportsToId = reportsToId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLastCURequestDate() {
        return lastCURequestDate;
    }

    public void setLastCURequestDate(String lastCURequestDate) {
        this.lastCURequestDate = lastCURequestDate;
    }

    public String getLastCUUpdateDate() {
        return lastCUUpdateDate;
    }

    public void setLastCUUpdateDate(String lastCUUpdateDate) {
        this.lastCUUpdateDate = lastCUUpdateDate;
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

    public String getEmailBouncedReason() {
        return emailBouncedReason;
    }

    public void setEmailBouncedReason(String emailBouncedReason) {
        this.emailBouncedReason = emailBouncedReason;
    }

    public String getEmailBouncedDate() {
        return emailBouncedDate;
    }

    public void setEmailBouncedDate(String emailBouncedDate) {
        this.emailBouncedDate = emailBouncedDate;
    }

    public Boolean isEmailBounced() {
        return isEmailBounced;
    }

    public void setEmailBounced(Boolean emailBounced) {
        isEmailBounced = emailBounced;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getJigsaw() {
        return jigsaw;
    }

    public void setJigsaw(String jigsaw) {
        this.jigsaw = jigsaw;
    }

    public String getJigsawContactId() {
        return jigsawContactId;
    }

    public void setJigsawContactId(String jigsawContactId) {
        this.jigsawContactId = jigsawContactId;
    }

    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public String getIndividualId() {
        return individualId;
    }

    public void setIndividualId(String individualId) {
        this.individualId = individualId;
    }

    public String getLevel__c() {
        return level__c;
    }

    public void setLevel__c(String level__c) {
        this.level__c = level__c;
    }

    public String getLanguages__c() {
        return languages__c;
    }

    public void setLanguages__c(String languages__c) {
        this.languages__c = languages__c;
    }
}
