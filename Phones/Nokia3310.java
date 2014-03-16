package name.sundrop.phones;

public class Nokia3310 extends Phone {

    public Nokia3310(String number) {
        super(number);
        touch = false;
        hasWifi = false;
        screenSize = 2;
    }

    @Override
    public void getAnswer() {
        System.out.println(this.getClass().getName() + ": " + number + " answer!");
    }

    @Override
    public void call(String number) {
        System.out.println("name.sundrop.phones.Nokia3310 class is calling to " + number);
        super.call(number);
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("name.sundrop.phones.Nokia3310 class is sending sms " + message + " to " + number);
    }
}
