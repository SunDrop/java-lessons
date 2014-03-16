package name.sundrop.phones;

public class IPhone5 extends IPhone {

    public IPhone5(String number) {
        super(number);
        screenSize = 4;
    }

    @Override
    public void getAnswer() {
//        super.getAnswer();
        System.out.println(this.getClass().getName() + ": " + number + " answer + красивая мелодия + видеоконференция!");
    }


    @Override
    public void sendSMS(String number, String message) {
        super.sendSMS(number, message);
        System.out.println("name.sundrop.phones.IPhone5 class is sending sms " + message + " to " + number);
    }
}
