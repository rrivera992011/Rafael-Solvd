class Shipment {
    private Person sender;
    private Person recipient;
    private Insurance insurance;

    private TotalPrice price;

    public Shipment(){

    }
    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getSender() {
        return sender;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return this.insurance;
    }

    public void setPrice(TotalPrice price) {
        this.price = price;
    }

    public TotalPrice getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return ("\nName of sender: " + sender.getName() +
                "\nAddress of sender: " + sender.getAddress() +
                "\nPhone number: " + sender.getPhoneNumber() +
                "\n\nName of recipient: " + recipient.getName() +
                "\nAddress of sender: " + recipient.getAddress() +
                "\nPhone number: " + recipient.getPhoneNumber() +
                "\n\nInsurance number: " + insurance.getInsuranceNumber() +
                "\n\nETA: " + price.getDays() + " Day(s)");
    }
}
