package com.solvd.delivery.enums;

public enum DriverStatus{
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        ON_HOLD("On Hold");
        private String status;
        DriverStatus(String status){
            this.status = status;
        }

        public String getDriverStatus() {
            return this.status;
        }
}
