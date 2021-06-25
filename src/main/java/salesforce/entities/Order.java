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
public class Order {

    private Attribute attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("OwnerId")
    private String ownerId;
    @JsonProperty("ContractId")
    private String contractId;
    @JsonProperty("AccountId")
    private String accountId;
    @JsonProperty("Pricebook2Id")
    private String pricebook2Id;
    @JsonProperty("OriginalOrderId")
    private String originalOrderId;
    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("IsReductionOrder")
    private Boolean isReductionOrder;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("CustomerAuthorizedById")
    private String customerAuthorizedById;
    @JsonProperty("CustomerAuthorizedDate")
    private String customerAuthorizedDate;
    @JsonProperty("CompanyAuthorizedById")
    private String companyAuthorizedById;
    @JsonProperty("CompanyAuthorizedDate")
    private String companyAuthorizedDate;
    @JsonProperty("Type")
    private String type;
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
    @JsonProperty("ShippingStreet")
    private String shippingStreet;
    @JsonProperty("ShippingCity")
    private String shippingCity;
    @JsonProperty("ShippingState")
    private String shippingState;
    @JsonProperty("ShippingPostalCode")
    private String shippingPostalCode;
    @JsonProperty("ShippingCountry")
    private String shippingCountry;
    @JsonProperty("ShippingLatitude")
    private String shippingLatitude;
    @JsonProperty("ShippingLongitude")
    private String shippingLongitude;
    @JsonProperty("ShippingGeocodeAccuracy")
    private String shippingGeocodeAccuracy;
    @JsonProperty("ShippingAddress")
    private String shippingAddress;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("PoDate")
    private String poDate;
    @JsonProperty("PoNumber")
    private String poNumber;
    @JsonProperty("OrderReferenceNumber")
    private String orderReferenceNumber;
    @JsonProperty("BillToContactId")
    private String billToContactId;
    @JsonProperty("ShipToContactId")
    private String shipToContactId;
    @JsonProperty("ActivatedDate")
    private String activatedDate;
    @JsonProperty("ActivatedById")
    private String activatedById;
    @JsonProperty("StatusCode")
    private String statusCode;
    @JsonProperty("OrderNumber")
    private String orderNumber;
    @JsonProperty("TotalAmount")
    private Double totalAmount;
    @JsonProperty("CreatedDate")
    private Date createdDate;
    @JsonProperty("CreatedById")
    private String createdById;
    @JsonProperty("LastModifiedDate")
    private Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    private String lastModifiedById;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("SystemModstamp")
    private Date systemModstamp;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(final String contractId) {
        this.contractId = contractId;
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

    public String getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(final String originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(final String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    public Boolean isReductionOrder() {
        return isReductionOrder;
    }

    public void setReductionOrder(final Boolean reductionOrder) {
        isReductionOrder = reductionOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getCustomerAuthorizedById() {
        return customerAuthorizedById;
    }

    public void setCustomerAuthorizedById(final String customerAuthorizedById) {
        this.customerAuthorizedById = customerAuthorizedById;
    }

    public String getCustomerAuthorizedDate() {
        return customerAuthorizedDate;
    }

    public void setCustomerAuthorizedDate(final String customerAuthorizedDate) {
        this.customerAuthorizedDate = customerAuthorizedDate;
    }

    public String getCompanyAuthorizedById() {
        return companyAuthorizedById;
    }

    public void setCompanyAuthorizedById(final String companyAuthorizedById) {
        this.companyAuthorizedById = companyAuthorizedById;
    }

    public String getCompanyAuthorizedDate() {
        return companyAuthorizedDate;
    }

    public void setCompanyAuthorizedDate(final String companyAuthorizedDate) {
        this.companyAuthorizedDate = companyAuthorizedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
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

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(final String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(final String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(final String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setShippingPostalCode(final String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(final String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingLatitude() {
        return shippingLatitude;
    }

    public void setShippingLatitude(final String shippingLatitude) {
        this.shippingLatitude = shippingLatitude;
    }

    public String getShippingLongitude() {
        return shippingLongitude;
    }

    public void setShippingLongitude(final String shippingLongitude) {
        this.shippingLongitude = shippingLongitude;
    }

    public String getShippingGeocodeAccuracy() {
        return shippingGeocodeAccuracy;
    }

    public void setShippingGeocodeAccuracy(final String shippingGeocodeAccuracy) {
        this.shippingGeocodeAccuracy = shippingGeocodeAccuracy;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(final String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(final String poDate) {
        this.poDate = poDate;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(final String poNumber) {
        this.poNumber = poNumber;
    }

    public String getOrderReferenceNumber() {
        return orderReferenceNumber;
    }

    public void setOrderReferenceNumber(final String orderReferenceNumber) {
        this.orderReferenceNumber = orderReferenceNumber;
    }

    public String getBillToContactId() {
        return billToContactId;
    }

    public void setBillToContactId(final String billToContactId) {
        this.billToContactId = billToContactId;
    }

    public String getShipToContactId() {
        return shipToContactId;
    }

    public void setShipToContactId(final String shipToContactId) {
        this.shipToContactId = shipToContactId;
    }

    public String getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(final String activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getActivatedById() {
        return activatedById;
    }

    public void setActivatedById(final String activatedById) {
        this.activatedById = activatedById;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(final String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final Double totalAmount) {
        this.totalAmount = totalAmount;
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

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(final Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(final Date systemModstamp) {
        this.systemModstamp = systemModstamp;
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
