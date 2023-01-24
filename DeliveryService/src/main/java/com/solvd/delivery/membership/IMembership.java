package com.solvd.delivery.membership;

import com.solvd.delivery.person.*;

public interface IMembership {
    void setPerson(Person person);
    Person getPerson();
    String getMembershipNumber();
    void setMembershipNumber(String membershipNumber);
}
