package name.sundrop.phones;

public interface iBasePhone {

    public void call(String number);

    public void getAnswer();

    public void sendSMS(String number, String message);

    public void print();

    public String getNumber();
}
