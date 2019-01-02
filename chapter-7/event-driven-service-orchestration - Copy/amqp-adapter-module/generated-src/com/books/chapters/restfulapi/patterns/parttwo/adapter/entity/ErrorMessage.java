
package com.books.chapters.restfulapi.patterns.parttwo.adapter.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * ErrorMessage
 * <p>
 * Errors
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "message",
    "details"
})
public class ErrorMessage implements Serializable
{

    /**
     * error code short desc.
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("error code short desc.")
    private String code;
    /**
     * error message.
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("error message.")
    private String message;
    /**
     * error description.
     * 
     */
    @JsonProperty("details")
    @JsonPropertyDescription("error description.")
    private String details;
    private final static long serialVersionUID = -4507943950993105368L;

    /**
     * error code short desc.
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * error code short desc.
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public ErrorMessage withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * error message.
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * error message.
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * error description.
     * 
     */
    @JsonProperty("details")
    public String getDetails() {
        return details;
    }

    /**
     * error description.
     * 
     */
    @JsonProperty("details")
    public void setDetails(String details) {
        this.details = details;
    }

    public ErrorMessage withDetails(String details) {
        this.details = details;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("message", message).append("details", details).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(details).append(code).append(message).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ErrorMessage) == false) {
            return false;
        }
        ErrorMessage rhs = ((ErrorMessage) other);
        return new EqualsBuilder().append(details, rhs.details).append(code, rhs.code).append(message, rhs.message).isEquals();
    }

}
