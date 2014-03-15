package name.sundrop.phones;

public class IPhone extends Phone {

    public IPhone(String number) {
        super(number);
        touch = true;
        hasWifi = true;
        screenSize = 3;
    }

    @Override
    public void getAnswer() {
        super.getAnswer();
        System.out.println(this.getClass().getName() + ": " + number + " answer + красивая мелодия!");
    }

    @Override
    final public void call(String number) {
        System.out.println(this.getClass().getName() + " class is calling to " + number);
        super.call(number);
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("name.sundrop.phones.IPhone class is sending sms " + message + " to " + number);
    }
}
