package name.sundrop.phones;

public class MainClass {

    public static void main(String[] args) {

        Nokia3310 nokia = new Nokia3310("111-11-11");
        IPhone iphone = new IPhone("222-22-22");
        IPhone5 iphone5 = new IPhone5("333-33-33");
        SamsungS4 samsungS4 = new SamsungS4("444-44-44");
        SamsungS4 samsungS4v2 = new SamsungS4("777-77-77");


        nokia.call("111-11-11");
        nokia.call("222-22-22");
        iphone.call("444-44-44");
        iphone5.call("111-11-11");
        samsungS4.call("333-33-33");
        samsungS4.call("555-55-55");

        System.out.println("----------------------------------");
        Phone.showAllList();
    }
}
