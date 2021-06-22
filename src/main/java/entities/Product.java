/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package entities;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "createdById",
        "createdDate",
        "description",
        "displayUrl",
        "externalDataSourceId",
        "externalId",
        "family",
        "id",
        "isActive",
        "isArchived",
        "isDeleted",
        "lastModifiedById",
        "lastModifiedDate",
        "lastReferencedDate",
        "lastViewedDate",
        "name",
        "productCode",
        "quantityUnitOfMeasure",
        "stockKeepingUnit",
        "systemModstamp",
})
public class Product {
    @JsonProperty("createdById")
    private Integer createdById;
    @JsonProperty("createdDate")
    private Integer createdDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayUrl")
    private String displayUrl;
    @JsonProperty("externalDataSourceId")
    private Integer externalDataSourceId;
    @JsonProperty("externalId")
    private String externalId;
    @JsonProperty("family")
    private String family;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("isArchived")
    private Boolean isArchived;
    @JsonProperty("isDeleted")
    private Boolean isDeleted;
    @JsonProperty("lastModifiedById")
    private Integer lastModifiedById;
    @JsonProperty("lastModifiedDate")
    private String lastModifiedDate;
    @JsonProperty("lastReferencedDate")
    private String lastReferencedDate;
    @JsonProperty("lastViewedDate")
    private String lastViewedDate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("quantityUnitOfMeasure")
    private String quantityUnitOfMeasure;
    @JsonProperty("stockKeepingUnit")
    private String stockKeepingUnit;
    @JsonProperty("systemModstamp")
    private String systemModstamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("createdById")
    public Integer getCreatedById() {
        return createdById;
    }

    @JsonProperty("createdById")
    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    @JsonProperty("createdDate")
    public Integer getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("displayUrl")
    public String getDisplayUrl() {
        return displayUrl;
    }

    @JsonProperty("displayUrl")
    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    @JsonProperty("externalDataSourceId")
    public Integer getExternalDataSourceId() {
        return externalDataSourceId;
    }

    @JsonProperty("externalDataSourceId")
    public void setExternalDataSourceId(Integer externalDataSourceId) {
        this.externalDataSourceId = externalDataSourceId;
    }

    @JsonProperty("externalId")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("family")
    public String getFamily() {
        return family;
    }

    @JsonProperty("family")
    public void setFamily(String family) {
        this.family = family;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("isActive")
    public Boolean isActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setActive(Boolean active) {
        isActive = active;
    }

    @JsonProperty("isArchived")
    public Boolean isArchived() {
        return isArchived;
    }

    @JsonProperty("isArchived")
    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    @JsonProperty("isDeleted")
    public Boolean isDeleted() {
        return isDeleted;
    }

    @JsonProperty("isDeleted")
    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @JsonProperty("lastModifiedById")
    public Integer getLastModifiedById() {
        return lastModifiedById;
    }

    @JsonProperty("lastModifiedById")
    public void setLastModifiedById(Integer lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    @JsonProperty("lastModifiedDate")
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    @JsonProperty("lastModifiedDate")
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @JsonProperty("lastReferencedDate")
    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    @JsonProperty("lastReferencedDate")
    public void setLastReferencedDate(String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    @JsonProperty("lastViewedDate")
    public String getLastViewedDate() {
        return lastViewedDate;
    }

    @JsonProperty("lastViewedDate")
    public void setLastViewedDate(String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("quantityUnitOfMeasure")
    public String getQuantityUnitOfMeasure() {
        return quantityUnitOfMeasure;
    }

    @JsonProperty("quantityUnitOfMeasure")
    public void setQuantityUnitOfMeasure(String quantityUnitOfMeasure) {
        this.quantityUnitOfMeasure = quantityUnitOfMeasure;
    }

    @JsonProperty("stockKeepingUnit")
    public String getStockKeepingUnit() {
        return stockKeepingUnit;
    }

    @JsonProperty("stockKeepingUnit")
    public void setStockKeepingUnit(String stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
    }

    @JsonProperty("systemModstamp")
    public String getSystemModstamp() {
        return systemModstamp;
    }

    @JsonProperty("systemModstamp")
    public void setSystemModstamp(String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
