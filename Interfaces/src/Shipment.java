class Shipment {
    private People sender;
    private People recipient;
    private Insurance insurance;

    private TotalPrice price;

    public Shipment(){

    }
    public void setSender(People sender) {
        this.sender = sender;
    }

    public People getSender() {
        return sender;
    }

    public void setRecipient(People recipient) {
        this.recipient = recipient;
    }

    public People getRecipient() {
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
                "\nName of recipient: " + recipient.getName() +
                "\nAddress of sender: " + recipient.getAddress() +
                "\nPhone number: " + recipient.getPhoneNumber() +
                "\nInsurance number: " + insurance.getInsuranceNumber() +
                "\nETA: " + price.getDays() + " Day(s)");
    }
}
