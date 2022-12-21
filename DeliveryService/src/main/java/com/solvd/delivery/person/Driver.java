package com.solvd.delivery.person;


public class Driver extends Employee{

    public enum DriverStatus{
        CAN_DRIVE(true),
        CANNOT_DRIVE(false);
        private boolean driverStatus;
        DriverStatus(boolean driverStatus){
            this.driverStatus = driverStatus;
        }

        public boolean getDriverStatus() {
            return this.driverStatus;
        }
    }





}
