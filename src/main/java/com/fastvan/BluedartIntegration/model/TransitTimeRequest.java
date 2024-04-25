package com.fastvan.BluedartIntegration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransitTimeRequest {
    @JsonProperty("pPinCodeFrom")
    private String pPinCodeFrom;
    @JsonProperty("pPinCodeTo")
    private String pPinCodeTo;
    @JsonProperty("pSubProductCode")
    private String pSubProductCode;
    @JsonProperty("pProductCode")
    private String pProductCode;
    @JsonProperty("pPudate")
    private String pPudate;
    @JsonProperty("pPickupTime")
    private String pPickupTime;
    @JsonProperty("profile")
    private Profile profile;

    public String getpPinCodeFrom() {
        return pPinCodeFrom;
    }

    public void setpPinCodeFrom(String pPinCodeFrom) {
        this.pPinCodeFrom = pPinCodeFrom;
    }

    public String getpPinCodeTo() {
        return pPinCodeTo;
    }

    public void setpPinCodeTo(String pPinCodeTo) {
        this.pPinCodeTo = pPinCodeTo;
    }

    public String getpSubProductCode() {
        return pSubProductCode;
    }

    public void setpSubProductCode(String pSubProductCode) {
        this.pSubProductCode = pSubProductCode;
    }

    public String getpPudate() {
        return pPudate;
    }

    public void setpPudate(String pPudate) {
        this.pPudate = pPudate;
    }

    public String getpPickupTime() {
        return pPickupTime;
    }

    public void setpPickupTime(String pPickupTime) {
        this.pPickupTime = pPickupTime;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getpProductCode() {
        return pProductCode;
    }

    public void setpProductCode(String pProductCode) {
        this.pProductCode = pProductCode;
    }

    public static class Profile{
        @JsonProperty("Api_type")
        private String api_type;
        @JsonProperty("LicenceKey")
        private String licenceKey;
        @JsonProperty("LoginID")
        private String loginID;

        public String getApi_type() {
            return api_type;
        }

        public void setApi_type(String api_type) {
            this.api_type = api_type;
        }

        public String getLicenceKey() {
            return licenceKey;
        }

        public void setLicenceKey(String licenceKey) {
            this.licenceKey = licenceKey;
        }

        public String getLoginID() {
            return loginID;
        }

        public void setLoginID(String loginID) {
            this.loginID = loginID;
        }
    }
}
