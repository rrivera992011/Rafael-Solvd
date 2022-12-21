package com.solvd.delivery.membership;

import com.solvd.delivery.person.*;

public class MembershipInformation implements IMembership {

    private Person person;
    private String membershipNumber;

    public enum OfferStatus{
        YES_OFFERS("Yes"),
        NO_OFFERS("No");

        private String offerStatus;

        OfferStatus(String offerStatus){
            this.offerStatus = offerStatus;
        }

        public String getOfferStatus(){
            return this.offerStatus;
        }
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Person getPerson() {
        return this.person;
    }

    @Override
    public String getMembershipNumber() {
        return this.membershipNumber;
    }

    @Override
    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }
}
