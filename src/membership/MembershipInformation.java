package membership;

import person.Person;

public class MembershipInformation implements IMembership {

    private Person person;
    private boolean offerStatus;

    private long membershipNumber;


    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Person getPerson() {
        return this.person;
    }

    @Override
    public long getMembershipNumber() {
        return this.membershipNumber;
    }

    @Override
    public void setMembershipNumber(long membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    @Override
    public void setOfferStatus(boolean offerStatus) {
        this.offerStatus = offerStatus;
    }

    @Override
    public boolean getOfferStatus() {
        return this.offerStatus;
    }
}
