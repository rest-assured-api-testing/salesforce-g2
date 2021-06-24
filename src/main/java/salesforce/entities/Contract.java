package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contract {

    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("AccountId")
    public String accountId;
    @JsonProperty("Pricebook2Id")
    public String pricebook2Id;
    @JsonProperty("OwnerExpirationNotice")
    public String ownerExpirationNotice;
    @JsonProperty("StartDate")
    public String startDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("BillingStreet")
    public String billingStreet;
    @JsonProperty("BillingCity")
    public String billingCity;
    @JsonProperty("BillingState")
    public String billingState;
    @JsonProperty("BillingPostalCode")
    public String billingPostalCode;
    @JsonProperty("BillingCountry")
    public String billingCountry;
    @JsonProperty("BillingLatitude")
    public String billingLatitude;
    @JsonProperty("BillingLongitude")
    public String billingLongitude;
    @JsonProperty("BillingGeocodeAccuracy")
    public String billingGeocodeAccuracy;
    @JsonProperty("BillingAddress")
    public String billingAddress;
    @JsonProperty("ContractTerm")
    public Integer contractTerm;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("CompanySignedId")
    public String companySignedId;
    @JsonProperty("CompanySignedDate")
    public String companySignedDate;
    @JsonProperty("CustomerSignedId")
    public String customerSignedId;
    @JsonProperty("CustomerSignedTitle")
    public String customerSignedTitle;
    @JsonProperty("CustomerSignedDate")
    public String customerSignedDate;
    @JsonProperty("SpecialTerms")
    public String specialTerms;
    @JsonProperty("ActivatedById")
    public String activatedById;
    @JsonProperty("ActivatedDate")
    public String activatedDate;
    @JsonProperty("StatusCode")
    public String statusCode;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("ContractNumber")
    public String contractNumber;
    @JsonProperty("LastApprovedDate")
    public String lastApprovedDate;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPricebook2Id() {
        return pricebook2Id;
    }

    public void setPricebook2Id(String pricebook2Id) {
        this.pricebook2Id = pricebook2Id;
    }

    public String getOwnerExpirationNotice() {
        return ownerExpirationNotice;
    }

    public void setOwnerExpirationNotice(String ownerExpirationNotice) {
        this.ownerExpirationNotice = ownerExpirationNotice;
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

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingLatitude() {
        return billingLatitude;
    }

    public void setBillingLatitude(String billingLatitude) {
        this.billingLatitude = billingLatitude;
    }

    public String getBillingLongitude() {
        return billingLongitude;
    }

    public void setBillingLongitude(String billingLongitude) {
        this.billingLongitude = billingLongitude;
    }

    public String getBillingGeocodeAccuracy() {
        return billingGeocodeAccuracy;
    }

    public void setBillingGeocodeAccuracy(String billingGeocodeAccuracy) {
        this.billingGeocodeAccuracy = billingGeocodeAccuracy;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Integer getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Integer contractTerm) {
        this.contractTerm = contractTerm;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanySignedId() {
        return companySignedId;
    }

    public void setCompanySignedId(String companySignedId) {
        this.companySignedId = companySignedId;
    }

    public String getCompanySignedDate() {
        return companySignedDate;
    }

    public void setCompanySignedDate(String companySignedDate) {
        this.companySignedDate = companySignedDate;
    }

    public String getCustomerSignedId() {
        return customerSignedId;
    }

    public void setCustomerSignedId(String customerSignedId) {
        this.customerSignedId = customerSignedId;
    }

    public String getCustomerSignedTitle() {
        return customerSignedTitle;
    }

    public void setCustomerSignedTitle(String customerSignedTitle) {
        this.customerSignedTitle = customerSignedTitle;
    }

    public String getCustomerSignedDate() {
        return customerSignedDate;
    }

    public void setCustomerSignedDate(String customerSignedDate) {
        this.customerSignedDate = customerSignedDate;
    }

    public String getSpecialTerms() {
        return specialTerms;
    }

    public void setSpecialTerms(String specialTerms) {
        this.specialTerms = specialTerms;
    }

    public String getActivatedById() {
        return activatedById;
    }

    public void setActivatedById(String activatedById) {
        this.activatedById = activatedById;
    }

    public String getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(String activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getLastApprovedDate() {
        return lastApprovedDate;
    }

    public void setLastApprovedDate(String lastApprovedDate) {
        this.lastApprovedDate = lastApprovedDate;
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
}
