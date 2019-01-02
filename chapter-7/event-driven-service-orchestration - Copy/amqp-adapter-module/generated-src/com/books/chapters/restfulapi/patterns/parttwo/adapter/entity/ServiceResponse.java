
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
 * Service Response
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "relatedRequest",
    "createdDate",
    "createdBy",
    "statusCode",
    "errorMessage",
    "items"
})
public class ServiceResponse implements Serializable
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
    @JsonProperty("relatedRequest")
    @NotNull
    private String relatedRequest;
    @JsonProperty("createdDate")
    private Date createdDate;
    /**
     * The user or system who created this response
     * 
     */
    @JsonProperty("createdBy")
    @JsonPropertyDescription("The user or system who created this response")
    private String createdBy;
    /**
     * The status code indicating service invocation is successful or not
     * 
     */
    @JsonProperty("statusCode")
    @JsonPropertyDescription("The status code indicating service invocation is successful or not")
    private String statusCode;
    /**
     * ErrorMessage
     * <p>
     * Errors
     * 
     */
    @JsonProperty("errorMessage")
    @JsonPropertyDescription("Errors")
    @Valid
    private ErrorMessage errorMessage;
    @JsonProperty("items")
    @Valid
    private List<BusinessEntity> items = new ArrayList<BusinessEntity>();
    private final static long serialVersionUID = -6638643645728104287L;

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

    public ServiceResponse withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("relatedRequest")
    public String getRelatedRequest() {
        return relatedRequest;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("relatedRequest")
    public void setRelatedRequest(String relatedRequest) {
        this.relatedRequest = relatedRequest;
    }

    public ServiceResponse withRelatedRequest(String relatedRequest) {
        this.relatedRequest = relatedRequest;
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

    public ServiceResponse withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * The user or system who created this response
     * 
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * The user or system who created this response
     * 
     */
    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ServiceResponse withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * The status code indicating service invocation is successful or not
     * 
     */
    @JsonProperty("statusCode")
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * The status code indicating service invocation is successful or not
     * 
     */
    @JsonProperty("statusCode")
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public ServiceResponse withStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * ErrorMessage
     * <p>
     * Errors
     * 
     */
    @JsonProperty("errorMessage")
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    /**
     * ErrorMessage
     * <p>
     * Errors
     * 
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ServiceResponse withErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @JsonProperty("items")
    public List<BusinessEntity> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<BusinessEntity> items) {
        this.items = items;
    }

    public ServiceResponse withItems(List<BusinessEntity> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("relatedRequest", relatedRequest).append("createdDate", createdDate).append("createdBy", createdBy).append("statusCode", statusCode).append("errorMessage", errorMessage).append("items", items).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(createdDate).append(createdBy).append(relatedRequest).append(errorMessage).append(id).append(items).append(statusCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceResponse) == false) {
            return false;
        }
        ServiceResponse rhs = ((ServiceResponse) other);
        return new EqualsBuilder().append(createdDate, rhs.createdDate).append(createdBy, rhs.createdBy).append(relatedRequest, rhs.relatedRequest).append(errorMessage, rhs.errorMessage).append(id, rhs.id).append(items, rhs.items).append(statusCode, rhs.statusCode).isEquals();
    }

}
