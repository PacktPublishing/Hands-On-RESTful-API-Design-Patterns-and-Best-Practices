
package com.books.chapters.restfulapi.patterns.parttwo.adapter.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * BusinessEntity
 * <p>
 * Business entity model
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "entityType",
    "entitySpecification",
    "name",
    "status",
    "relatedEntities"
})
public class BusinessEntity implements Serializable
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @NotNull
    private String id;
    @JsonProperty("entityType")
    private String entityType;
    @JsonProperty("entitySpecification")
    private String entitySpecification;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("relatedEntities")
    @Valid
    private List<BusinessEntity> relatedEntities = new ArrayList<BusinessEntity>();
    private final static long serialVersionUID = 2101422972316505107L;

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

    public BusinessEntity withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("entityType")
    public String getEntityType() {
        return entityType;
    }

    @JsonProperty("entityType")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public BusinessEntity withEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    @JsonProperty("entitySpecification")
    public String getEntitySpecification() {
        return entitySpecification;
    }

    @JsonProperty("entitySpecification")
    public void setEntitySpecification(String entitySpecification) {
        this.entitySpecification = entitySpecification;
    }

    public BusinessEntity withEntitySpecification(String entitySpecification) {
        this.entitySpecification = entitySpecification;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public BusinessEntity withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public BusinessEntity withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("relatedEntities")
    public List<BusinessEntity> getRelatedEntities() {
        return relatedEntities;
    }

    @JsonProperty("relatedEntities")
    public void setRelatedEntities(List<BusinessEntity> relatedEntities) {
        this.relatedEntities = relatedEntities;
    }

    public BusinessEntity withRelatedEntities(List<BusinessEntity> relatedEntities) {
        this.relatedEntities = relatedEntities;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("entityType", entityType).append("entitySpecification", entitySpecification).append("name", name).append("status", status).append("relatedEntities", relatedEntities).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(entityType).append(name).append(id).append(relatedEntities).append(entitySpecification).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BusinessEntity) == false) {
            return false;
        }
        BusinessEntity rhs = ((BusinessEntity) other);
        return new EqualsBuilder().append(entityType, rhs.entityType).append(name, rhs.name).append(id, rhs.id).append(relatedEntities, rhs.relatedEntities).append(entitySpecification, rhs.entitySpecification).append(status, rhs.status).isEquals();
    }

}
