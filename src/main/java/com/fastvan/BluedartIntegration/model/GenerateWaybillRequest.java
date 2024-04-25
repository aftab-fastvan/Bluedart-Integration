package com.fastvan.BluedartIntegration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class GenerateWaybillRequest {
    @JsonProperty("Request")
    private Request request;
    @JsonProperty("Profile")
    private Profile profile;
    public static class Request{
        @JsonProperty("Consignee")
        private Consignee consignee;
        @JsonProperty("Services")
        private Services service;
        @JsonProperty("Shipper")
        private Shipper shipper;
        @JsonProperty("Returnadds")
        private Returnadds returnadds;

        public Consignee getConsignee() {
            return consignee;
        }

        public void setConsignee(Consignee consignee) {
            this.consignee = consignee;
        }

        public Services getService() {
            return service;
        }

        public void setService(Services service) {
            this.service = service;
        }

        public Shipper getShipper() {
            return shipper;
        }

        public void setShipper(Shipper shipper) {
            this.shipper = shipper;
        }

        public Returnadds getReturnadds() {
            return returnadds;
        }

        public void setReturnadds(Returnadds returnadds) {
            this.returnadds = returnadds;
        }

        public static class Consignee{
            @JsonProperty("ConsigneeName")
            String consigneeName;
            @JsonProperty("ConsigneeAddress1")
            String consigneeAddress1;
            @JsonProperty("ConsigneePincode")
            String consigneePincode;
            @JsonProperty("ConsigneeMobile")
            String consigneeMobile;

            public String getConsigneeName() {
                return consigneeName;
            }

            public void setConsigneeName(String consigneeName) {
                this.consigneeName = consigneeName;
            }

            public String getConsigneeAddress1() {
                return consigneeAddress1;
            }

            public void setConsigneeAddress1(String consigneeAddress1) {
                this.consigneeAddress1 = consigneeAddress1;
            }

            public String getConsigneePincode() {
                return consigneePincode;
            }

            public void setConsigneePincode(String consigneePincode) {
                this.consigneePincode = consigneePincode;
            }

            public String getConsigneeMobile() {
                return consigneeMobile;
            }

            public void setConsigneeMobile(String consigneeMobile) {
                this.consigneeMobile = consigneeMobile;
            }
        }

        public static class Services{
            @JsonProperty("PieceCount")
            String pieceCount;
            @JsonProperty("PickupTime")
            String pickUpTime;
            @JsonProperty("ActualWeight")
            String actualWeight;
            @JsonProperty("ProductCode")
            String productCode;
            @JsonProperty("ProductType")
            int productType;
            @JsonProperty("Dimensions")
            List<Dimensions> dimensions;
            @JsonProperty("PickupDate")
            String pickUpDate;
            @JsonProperty("CreditReferenceNo")
            String creditReferenceNo;
            @JsonProperty("DeclaredValue")
            int declaredValue;
            //register pickup set to true by default to enable registration of the pickup while generation of Waybill
            @JsonProperty("RegisterPickup")
            boolean registerPickup = true;
            //below property returns pdf output(in bytestream) is set to false
            //by default set to true for readability
            @JsonProperty("PDFOutputNotRequired")
            boolean pdfOutputNotRequired = true;
            @JsonProperty("SubProductCode")
            String subProductCode;
            @JsonProperty("IsReversePickup")
            String isReversePickup;

            public String getPieceCount() {
                return pieceCount;
            }

            public void setPieceCount(String pieceCount) {
                this.pieceCount = pieceCount;
            }

            public String getPickUpTime() {
                return pickUpTime;
            }

            public void setPickUpTime(String pickUpTime) {
                this.pickUpTime = pickUpTime;
            }

            public String getActualWeight() {
                return actualWeight;
            }

            public void setActualWeight(String actualWeight) {
                this.actualWeight = actualWeight;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public int getProductType() {
                return productType;
            }

            public void setProductType(int productType) {
                this.productType = productType;
            }

            public List<Dimensions> getDimensions() {
                return dimensions;
            }

            public void setDimensions(List<Dimensions> dimensions) {
                this.dimensions = dimensions;
            }

            public String getPickUpDate() {
                return pickUpDate;
            }

            public void setPickUpDate(String pickUpDate) {
                this.pickUpDate = pickUpDate;
            }

            public String getCreditReferenceNo() {
                return creditReferenceNo;
            }

            public void setCreditReferenceNo(String creditReferenceNo) {
                this.creditReferenceNo = creditReferenceNo;
            }

            public int getDeclaredValue() {
                return declaredValue;
            }

            public void setDeclaredValue(int declaredValue) {
                this.declaredValue = declaredValue;
            }

        public boolean isRegisterPickup() {
            return registerPickup;
        }

        public void setRegisterPickup(boolean registerPickup) {
            this.registerPickup = registerPickup;
        }

        public boolean isPdfOutputNotRequired() {
                return pdfOutputNotRequired;
            }

            public void setPdfOutputNotRequired(boolean pdfOutputNotRequired) {
                this.pdfOutputNotRequired = pdfOutputNotRequired;
            }
        }

        public static class Dimensions{
            @JsonProperty("Length")
            int length;
            @JsonProperty("Breadth")
            int breadth;
            @JsonProperty("Height")
            int height;
            @JsonProperty("Count")
            int count;

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public int getBreadth() {
                return breadth;
            }

            public void setBreadth(int breadth) {
                this.breadth = breadth;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static class Shipper{
            @JsonProperty("CustomerCode")
            String customerCode;
            @JsonProperty("OriginArea")
            String originArea;
            @JsonProperty("CustomerPincode")
            String customerPincode;
            @JsonProperty("CustomerName")
            String customerName;
            @JsonProperty("CustomerAddress1")
            String customerAddress1;
            @JsonProperty("CustomerMobile")
            String customerMobile;

            public String getCustomerCode() {
                return customerCode;
            }

            public void setCustomerCode(String customerCode) {
                this.customerCode = customerCode;
            }

            public String getOriginArea() {
                return originArea;
            }

            public void setOriginArea(String originArea) {
                this.originArea = originArea;
            }

            public String getCustomerPincode() {
                return customerPincode;
            }

            public void setCustomerPincode(String customerPincode) {
                this.customerPincode = customerPincode;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getCustomerAddress1() {
                return customerAddress1;
            }

            public void setCustomerAddress1(String customerAddress1) {
                this.customerAddress1 = customerAddress1;
            }

            public String getCustomerMobile() {
                return customerMobile;
            }

            public void setCustomerMobile(String customerMobile) {
                this.customerMobile = customerMobile;
            }
        }

        public static class Returnadds{
            @JsonProperty("ReturnPincode")
            String returnPincode;
            @JsonProperty("ReturnAddress1")
            String returnAddress1;
            @JsonProperty("ReturnMobile")
            String returnMobile;
            public String getReturnPincode() {
                return returnPincode;
            }

            public void setReturnPincode(String returnPincode) {
                this.returnPincode = returnPincode;
            }

            public String getReturnAddress1() {
                return returnAddress1;
            }

            public void setReturnAddress1(String returnAddress1) {
                this.returnAddress1 = returnAddress1;
            }

            public String getReturnMobile() {
                return returnMobile;
            }

            public void setReturnMobile(String returnMobile) {
                this.returnMobile = returnMobile;
            }
        }
    }
    public static class Profile{
        @JsonProperty("LoginID")
        String loginID;
        @JsonProperty("Api_type")
        String apiType;
        @JsonProperty("LicenceKey")
        String licenceKey;

        public String getLoginID() {
            return loginID;
        }

        public void setLoginID(String loginID) {
            this.loginID = loginID;
        }

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
    }
}
