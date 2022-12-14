package com.solvd.delivery.complaint;

import com.solvd.delivery.shipment.Shipment;


public class PackageComplaint extends Complaint {

    private Shipment shipment;

    public Shipment getShipment() {
        return this.shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
