package com.fastvan.BluedartIntegration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PincodeRequest {
    @JsonProperty("pinCode")
    private String pinCode;
    @JsonProperty("profile")
    private Profile profile;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public static class Profile {
        @JsonProperty("Api_type")
        private String apiType;
        @JsonProperty("LicenceKey")
        private String licenceKey;
        @JsonProperty("LoginID")
        private String loginID;


        public String getApiType() {
            return apiType;
        }

        public void setApiType(String apiType) {
            this.apiType = apiType;
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
