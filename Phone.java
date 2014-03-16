package name.sundrop.phones;

public abstract class Phone implements iBasePhone {

    protected String number;
    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;

    private static int iAllCalls = 0;
    private int iOutCalls = 0;
    private int iInCalls = 0;

    protected static iBasePhone[] phoneList = new iBasePhone[100];
    protected static int iListNum = 0;

    public Phone(String number) {
        if (iListNum + 1 >= phoneList.length) {
            iBasePhone[] tmp = new iBasePhone[phoneList.length + 100];
            System.arraycopy(phoneList, 0, tmp, 0, phoneList.length);
            phoneList = tmp;
        }
        this.setNumber(number);
        phoneList[iListNum++] = this;
    }

    private static iBasePhone find(String number) throws Exception {
        for (int i = 0; i < iListNum; i++) {
            if (phoneList[i].getNumber().equalsIgnoreCase(number)) {
                return phoneList[i];
            }
        }
        throw new Exception("Указанный номер не существует!");
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public int getOutCalls() {
        return iOutCalls;
    }

    public int getInCalls() {
        return iInCalls;
    }

    /**
     * Вывести список всех телефонов
     */
    public static void showAllList() {
        for (int i = 0; i < iListNum; i++) {
            phoneList[i].print();
        }
        System.out.println("Всего исходящих звонков: " + Phone.iAllCalls);
    }

    public void print() {
        System.out.println(this.getClass().getName() + ": " + this.number
                + ", количество исходящих звонков: " + this.getOutCalls()
                + ", количество входящих звонков: " + this.getInCalls());
    }

    public boolean isTouch() {
        return touch;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void call(String number) {
        try {
            if (this.number.equalsIgnoreCase(number)) {
                throw new Exception("Занято! Вы звоните самому себе. Повторите попытку позднее, когда голоса в голове будут слышны четче.");
            }
            ((Phone)Phone.find(number))._getAnswer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        iAllCalls++;
        iOutCalls++;
    }

    private void _getAnswer() {
        iInCalls++;
        this.getAnswer();
    }

    public abstract void getAnswer();

    public abstract void sendSMS(String number, String message);
}
