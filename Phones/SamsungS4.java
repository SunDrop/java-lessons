package name.sundrop.phones;

public class SamsungS4 extends Phone {

    public SamsungS4(String number) {
        super(number);
        touch = true;
        hasWifi = true;
        screenSize = 5;
    }

    @Override
    public void call(String number) {
        System.out.println("name.sundrop.phones.SamsungS4 class is calling to " + number);
        super.call(number);
    }

    @Override
    public void getAnswer() {
        super.getAnswer();
        System.out.println(this.getClass().getName() + ": " + number + " answer + защита головы от ветра!");
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("name.sundrop.phones.SamsungS4 class is sending sms: Hello, " + message + " to " + number);
    }
}
