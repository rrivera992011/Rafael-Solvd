package membership;

public class Email implements IMembership {
    private String email;
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }
}
