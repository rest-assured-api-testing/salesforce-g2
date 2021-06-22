package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("ContractId")
    public String contractId;
    @JsonProperty("AccountId")
    public String accountId;
    @JsonProperty("Pricebook2Id")
    public String pricebook2Id;
    @JsonProperty("OriginalOrderId")
    public String originalOrderId;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("IsReductionOrder")
    public boolean isReductionOrder;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("CustomerAuthorizedById")
    public String customerAuthorizedById;
    @JsonProperty("CustomerAuthorizedDate")
    public String customerAuthorizedDate;
    @JsonProperty("CompanyAuthorizedById")
    public String companyAuthorizedById;
    @JsonProperty("CompanyAuthorizedDate")
    public String companyAuthorizedDate;
    @JsonProperty("Type")
    public String type;
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
    @JsonProperty("ShippingStreet")
    public String shippingStreet;
    @JsonProperty("ShippingCity")
    public String shippingCity;
    @JsonProperty("ShippingState")
    public String shippingState;
    @JsonProperty("ShippingPostalCode")
    public String shippingPostalCode;
    @JsonProperty("ShippingCountry")
    public String shippingCountry;
    @JsonProperty("ShippingLatitude")
    public String shippingLatitude;
    @JsonProperty("ShippingLongitude")
    public String shippingLongitude;
    @JsonProperty("ShippingGeocodeAccuracy")
    public String shippingGeocodeAccuracy;
    @JsonProperty("ShippingAddress")
    public String shippingAddress;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("PoDate")
    public String poDate;
    @JsonProperty("PoNumber")
    public String poNumber;
    @JsonProperty("OrderReferenceNumber")
    public String orderReferenceNumber;
    @JsonProperty("BillToContactId")
    public String billToContactId;
    @JsonProperty("ShipToContactId")
    public String shipToContactId;
    @JsonProperty("ActivatedDate")
    public String activatedDate;
    @JsonProperty("ActivatedById")
    public String activatedById;
    @JsonProperty("StatusCode")
    public String statusCode;
    @JsonProperty("OrderNumber")
    public String orderNumber;
    @JsonProperty("TotalAmount")
    public double totalAmount;
    @JsonProperty("CreatedDate")
    public Date createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("IsDeleted")
    public boolean isDeleted;
    @JsonProperty("SystemModstamp")
    public Date systemModstamp;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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

    public String getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isReductionOrder() {
        return isReductionOrder;
    }

    public void setReductionOrder(boolean reductionOrder) {
        isReductionOrder = reductionOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerAuthorizedById() {
        return customerAuthorizedById;
    }

    public void setCustomerAuthorizedById(String customerAuthorizedById) {
        this.customerAuthorizedById = customerAuthorizedById;
    }

    public String getCustomerAuthorizedDate() {
        return customerAuthorizedDate;
    }

    public void setCustomerAuthorizedDate(String customerAuthorizedDate) {
        this.customerAuthorizedDate = customerAuthorizedDate;
    }

    public String getCompanyAuthorizedById() {
        return companyAuthorizedById;
    }

    public void setCompanyAuthorizedById(String companyAuthorizedById) {
        this.companyAuthorizedById = companyAuthorizedById;
    }

    public String getCompanyAuthorizedDate() {
        return companyAuthorizedDate;
    }

    public void setCompanyAuthorizedDate(String companyAuthorizedDate) {
        this.companyAuthorizedDate = companyAuthorizedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingLatitude() {
        return shippingLatitude;
    }

    public void setShippingLatitude(String shippingLatitude) {
        this.shippingLatitude = shippingLatitude;
    }

    public String getShippingLongitude() {
        return shippingLongitude;
    }

    public void setShippingLongitude(String shippingLongitude) {
        this.shippingLongitude = shippingLongitude;
    }

    public String getShippingGeocodeAccuracy() {
        return shippingGeocodeAccuracy;
    }

    public void setShippingGeocodeAccuracy(String shippingGeocodeAccuracy) {
        this.shippingGeocodeAccuracy = shippingGeocodeAccuracy;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getOrderReferenceNumber() {
        return orderReferenceNumber;
    }

    public void setOrderReferenceNumber(String orderReferenceNumber) {
        this.orderReferenceNumber = orderReferenceNumber;
    }

    public String getBillToContactId() {
        return billToContactId;
    }

    public void setBillToContactId(String billToContactId) {
        this.billToContactId = billToContactId;
    }

    public String getShipToContactId() {
        return shipToContactId;
    }

    public void setShipToContactId(String shipToContactId) {
        this.shipToContactId = shipToContactId;
    }

    public String getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(String activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getActivatedById() {
        return activatedById;
    }

    public void setActivatedById(String activatedById) {
        this.activatedById = activatedById;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(Date systemModstamp) {
        this.systemModstamp = systemModstamp;
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
