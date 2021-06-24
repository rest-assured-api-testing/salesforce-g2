package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

    public Attribute attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("MasterRecordId")
    public String masterRecordId;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("ParentId")
    public String parentId;
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
    public Address billingAddress;
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
    public Address shippingAddress;
    @JsonProperty("Phone")
    public String phone;
    @JsonProperty("Fax")
    public String fax;
    @JsonProperty("AccountNumber")
    public String accountNumber;
    @JsonProperty("Website")
    public String website;
    @JsonProperty("PhotoUrl")
    public String photoUrl;
    @JsonProperty("Sic")
    public String sic;
    @JsonProperty("Industry")
    public String industry;
    @JsonProperty("AnnualRevenue")
    public String annualRevenue;
    @JsonProperty("NumberOfEmployees")
    public String numberOfEmployees;
    @JsonProperty("Ownership")
    public String ownership;
    @JsonProperty("TickerSymbol")
    public String tickerSymbol;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Rating")
    public String rating;
    @JsonProperty("Site")
    public String site;
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
    @JsonProperty("Jigsaw")
    public String jigsaw;
    @JsonProperty("JigsawCompanyId")
    public String jigsawCompanyId;
    @JsonProperty("CleanStatus")
    public String cleanStatus;
    @JsonProperty("AccountSource")
    public String accountSource;
    @JsonProperty("DunsNumber")
    public String dunsNumber;
    @JsonProperty("Tradestyle")
    public String tradestyle;
    @JsonProperty("NaicsCode")
    public String naicsCode;
    @JsonProperty("NaicsDesc")
    public String naicsDesc;
    @JsonProperty("YearStarted")
    public String yearStarted;
    @JsonProperty("SicDesc")
    public String sicDesc;
    @JsonProperty("DandbCompanyId")
    public String dandbCompanyId;
    @JsonProperty("OperatingHoursId")
    public String operatingHoursId;
    @JsonProperty("CustomerPriority__c")
    public String customerPriority__c;
    @JsonProperty("SLA__c")
    public String sLA__c;
    @JsonProperty("Active__c")
    public String active__c;
    @JsonProperty("NumberofLocations__c")
    public String numberofLocations__c;
    @JsonProperty("UpsellOpportunity__c")
    public String upsellOpportunity__c;
    @JsonProperty("SLASerialNumber__c")
    public String sLASerialNumber__c;
    @JsonProperty("SLAExpirationDate__c")
    public String sLAExpirationDate__c;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
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

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getSic() {
        return sic;
    }

    public void setSic(String sic) {
        this.sic = sic;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public String getJigsaw() {
        return jigsaw;
    }

    public void setJigsaw(String jigsaw) {
        this.jigsaw = jigsaw;
    }

    public String getJigsawCompanyId() {
        return jigsawCompanyId;
    }

    public void setJigsawCompanyId(String jigsawCompanyId) {
        this.jigsawCompanyId = jigsawCompanyId;
    }

    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public String getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(String accountSource) {
        this.accountSource = accountSource;
    }

    public String getDunsNumber() {
        return dunsNumber;
    }

    public void setDunsNumber(String dunsNumber) {
        this.dunsNumber = dunsNumber;
    }

    public String getTradestyle() {
        return tradestyle;
    }

    public void setTradestyle(String tradestyle) {
        this.tradestyle = tradestyle;
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode;
    }

    public String getNaicsDesc() {
        return naicsDesc;
    }

    public void setNaicsDesc(String naicsDesc) {
        this.naicsDesc = naicsDesc;
    }

    public String getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(String yearStarted) {
        this.yearStarted = yearStarted;
    }

    public String getSicDesc() {
        return sicDesc;
    }

    public void setSicDesc(String sicDesc) {
        this.sicDesc = sicDesc;
    }

    public String getDandbCompanyId() {
        return dandbCompanyId;
    }

    public void setDandbCompanyId(String dandbCompanyId) {
        this.dandbCompanyId = dandbCompanyId;
    }

    public String getOperatingHoursId() {
        return operatingHoursId;
    }

    public void setOperatingHoursId(String operatingHoursId) {
        this.operatingHoursId = operatingHoursId;
    }

    public String getCustomerPriority__c() {
        return customerPriority__c;
    }

    public void setCustomerPriority__c(String customerPriority__c) {
        this.customerPriority__c = customerPriority__c;
    }

    public String getsLA__c() {
        return sLA__c;
    }

    public void setsLA__c(String sLA__c) {
        this.sLA__c = sLA__c;
    }

    public String getActive__c() {
        return active__c;
    }

    public void setActive__c(String active__c) {
        this.active__c = active__c;
    }

    public String getNumberofLocations__c() {
        return numberofLocations__c;
    }

    public void setNumberofLocations__c(String numberofLocations__c) {
        this.numberofLocations__c = numberofLocations__c;
    }

    public String getUpsellOpportunity__c() {
        return upsellOpportunity__c;
    }

    public void setUpsellOpportunity__c(String upsellOpportunity__c) {
        this.upsellOpportunity__c = upsellOpportunity__c;
    }

    public String getsLASerialNumber__c() {
        return sLASerialNumber__c;
    }

    public void setsLASerialNumber__c(String sLASerialNumber__c) {
        this.sLASerialNumber__c = sLASerialNumber__c;
    }

    public String getsLAExpirationDate__c() {
        return sLAExpirationDate__c;
    }

    public void setsLAExpirationDate__c(String sLAExpirationDate__c) {
        this.sLAExpirationDate__c = sLAExpirationDate__c;
    }
}
