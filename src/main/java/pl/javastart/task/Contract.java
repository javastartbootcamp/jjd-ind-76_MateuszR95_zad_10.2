package pl.javastart.task;

public abstract class Contract {

    public abstract boolean canSendSms();

    public abstract boolean canSendMms();

    public abstract boolean canCall(int seconds);

    public abstract double getRemainingAccountBalance();

    public abstract void useSmsService(double amount);

    public abstract void useMmsService(double amount);

    public abstract void useCallService(double amount, int seconds);

    public abstract double createBill();

    public abstract boolean isCardPhoneContract();

    public abstract boolean isSubscription();

    public abstract boolean isMixContract();

    abstract double getSmsPrice();

    abstract double getMmsPrice();

    abstract double getCallPrice();

}
