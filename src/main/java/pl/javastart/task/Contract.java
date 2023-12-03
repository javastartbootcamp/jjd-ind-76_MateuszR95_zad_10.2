package pl.javastart.task;

public abstract class Contract {

    public abstract boolean canSendSms();

    public abstract boolean canSendMms();

    public abstract double getRemainingAccountBalance();

    public abstract void useSmsService();

    public abstract void useMmsService();

    public abstract int useCallService(int seconds);

    public abstract String getAccountState();

    public abstract double createBill();

}
