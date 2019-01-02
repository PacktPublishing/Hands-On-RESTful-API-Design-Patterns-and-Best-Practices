
package com.books.chapters.restfulapi.patterns.parttwo.adapter.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Service Request
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "serviceName",
    "serviceAction",
    "createdDate",
    "createdBy",
    "items"
})
public class ServiceRequest implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @NotNull
    private String id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceName")
    @NotNull
    private String serviceName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceAction")
    @NotNull
    private String serviceAction;
    @JsonProperty("createdDate")
    private Date createdDate;
    /**
     * The user or system who created this request
     * 
     */
    @JsonProperty("createdBy")
    @JsonPropertyDescription("The user or system who created this request")
    private String createdBy;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("items")
    @Valid
    @NotNull
    private List<BusinessEntity> items = new ArrayList<BusinessEntity>();
    private final static long serialVersionUID = 7784954294523233701L;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public ServiceRequest withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public ServiceRequest withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceAction")
    public String getServiceAction() {
        return serviceAction;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceAction")
    public void setServiceAction(String serviceAction) {
        this.serviceAction = serviceAction;
    }

    public ServiceRequest withServiceAction(String serviceAction) {
        this.serviceAction = serviceAction;
        return this;
    }

    @JsonProperty("createdDate")
    public Date getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ServiceRequest withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * The user or system who created this request
     * 
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * The user or system who created this request
     * 
     */
    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ServiceRequest withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("items")
    public List<BusinessEntity> getItems() {
        return items;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("items")
    public void setItems(List<BusinessEntity> items) {
        this.items = items;
    }

    public ServiceRequest withItems(List<BusinessEntity> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("serviceName", serviceName).append("serviceAction", serviceAction).append("createdDate", createdDate).append("createdBy", createdBy).append("items", items).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(createdDate).append(createdBy).append(serviceAction).append(id).append(serviceName).append(items).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceRequest) == false) {
            return false;
        }
        ServiceRequest rhs = ((ServiceRequest) other);
        return new EqualsBuilder().append(createdDate, rhs.createdDate).append(createdBy, rhs.createdBy).append(serviceAction, rhs.serviceAction).append(id, rhs.id).append(serviceName, rhs.serviceName).append(items, rhs.items).isEquals();
    }

}
