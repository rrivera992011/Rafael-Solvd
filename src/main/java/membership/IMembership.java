package main.java.membership;

import main.java.person.*;

public interface IMembership {

    void setPerson(Person person);
    Person getPerson();

    long getMembershipNumber();

    void setMembershipNumber(long membershipNumber);

    void setOfferStatus(boolean offerStatus);
    boolean getOfferStatus();

}
