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
public class Contract {

    private Attribute attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("AccountId")
    private String accountId;
    @JsonProperty("Pricebook2Id")
    private String pricebook2Id;
    @JsonProperty("OwnerExpirationNotice")
    private String ownerExpirationNotice;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("BillingStreet")
    private String billingStreet;
    @JsonProperty("BillingCity")
    private String billingCity;
    @JsonProperty("BillingState")
    private String billingState;
    @JsonProperty("BillingPostalCode")
    private String billingPostalCode;
    @JsonProperty("BillingCountry")
    private String billingCountry;
    @JsonProperty("BillingLatitude")
    private String billingLatitude;
    @JsonProperty("BillingLongitude")
    private String billingLongitude;
    @JsonProperty("BillingGeocodeAccuracy")
    private String billingGeocodeAccuracy;
    @JsonProperty("BillingAddress")
    private String billingAddress;
    @JsonProperty("ContractTerm")
    private Integer contractTerm;
    @JsonProperty("OwnerId")
    private String ownerId;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("CompanySignedId")
    private String companySignedId;
    @JsonProperty("CompanySignedDate")
    private String companySignedDate;
    @JsonProperty("CustomerSignedId")
    private String customerSignedId;
    @JsonProperty("CustomerSignedTitle")
    private String customerSignedTitle;
    @JsonProperty("CustomerSignedDate")
    private String customerSignedDate;
    @JsonProperty("SpecialTerms")
    private String specialTerms;
    @JsonProperty("ActivatedById")
    private String activatedById;
    @JsonProperty("ActivatedDate")
    private String activatedDate;
    @JsonProperty("StatusCode")
    private String statusCode;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("ContractNumber")
    private String contractNumber;
    @JsonProperty("LastApprovedDate")
    private String lastApprovedDate;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public String getPricebook2Id() {
        return pricebook2Id;
    }

    public void setPricebook2Id(final String pricebook2Id) {
        this.pricebook2Id = pricebook2Id;
    }

    public String getOwnerExpirationNotice() {
        return ownerExpirationNotice;
    }

    public void setOwnerExpirationNotice(final String ownerExpirationNotice) {
        this.ownerExpirationNotice = ownerExpirationNotice;
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

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(final String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(final String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(final String billingState) {
        this.billingState = billingState;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(final String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(final String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingLatitude() {
        return billingLatitude;
    }

    public void setBillingLatitude(final String billingLatitude) {
        this.billingLatitude = billingLatitude;
    }

    public String getBillingLongitude() {
        return billingLongitude;
    }

    public void setBillingLongitude(final String billingLongitude) {
        this.billingLongitude = billingLongitude;
    }

    public String getBillingGeocodeAccuracy() {
        return billingGeocodeAccuracy;
    }

    public void setBillingGeocodeAccuracy(final String billingGeocodeAccuracy) {
        this.billingGeocodeAccuracy = billingGeocodeAccuracy;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(final String billingAddress) {
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

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getCompanySignedId() {
        return companySignedId;
    }

    public void setCompanySignedId(final String companySignedId) {
        this.companySignedId = companySignedId;
    }

    public String getCompanySignedDate() {
        return companySignedDate;
    }

    public void setCompanySignedDate(final String companySignedDate) {
        this.companySignedDate = companySignedDate;
    }

    public String getCustomerSignedId() {
        return customerSignedId;
    }

    public void setCustomerSignedId(final String customerSignedId) {
        this.customerSignedId = customerSignedId;
    }

    public String getCustomerSignedTitle() {
        return customerSignedTitle;
    }

    public void setCustomerSignedTitle(final String customerSignedTitle) {
        this.customerSignedTitle = customerSignedTitle;
    }

    public String getCustomerSignedDate() {
        return customerSignedDate;
    }

    public void setCustomerSignedDate(final String customerSignedDate) {
        this.customerSignedDate = customerSignedDate;
    }

    public String getSpecialTerms() {
        return specialTerms;
    }

    public void setSpecialTerms(final String specialTerms) {
        this.specialTerms = specialTerms;
    }

    public String getActivatedById() {
        return activatedById;
    }

    public void setActivatedById(final String activatedById) {
        this.activatedById = activatedById;
    }

    public String getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(final String activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(final Boolean deleted) {
        isDeleted = deleted;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(final String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getLastApprovedDate() {
        return lastApprovedDate;
    }

    public void setLastApprovedDate(final String lastApprovedDate) {
        this.lastApprovedDate = lastApprovedDate;
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
}
