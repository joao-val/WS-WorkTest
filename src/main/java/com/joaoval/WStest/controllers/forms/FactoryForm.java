package com.joaoval.WStest.controllers.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FactoryForm {

    @NotBlank(message = "A valid factoryName is required")
    @Length(min = 2, max = 30, message = "factoryName must to be a maximum of {max} characters")
    private String factoryName;

    @NotBlank(message = "A valid countryCode is required")
    @Pattern(regexp = "[A-Z]{2}", message = "countryCode must have only 2 capital letters")
    private String countryCode;
    
    public FactoryForm() {
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
