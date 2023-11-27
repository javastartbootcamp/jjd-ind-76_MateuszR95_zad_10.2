package pl.javastart.task;

public class Subscription extends Contract {

    private double subscriptionFee;

    public Subscription(double price) {
        this.subscriptionFee = price;
    }

    public double getPrice() {
        return subscriptionFee;
    }

    public void setPrice(double price) {
        this.subscriptionFee = price;
    }

    @Override
    public boolean canSendSms() {
        return true;
    }

    @Override
    public boolean canSendMms() {
        return true;
    }

    @Override
    public boolean canCall(int seconds) {
        return true;
    }

    @Override
    public double getRemainingAccountBalance() {
        return 0;
    }

    @Override
    public void useSmsService(double amount) {

    }

    @Override
    public void useMmsService(double amount) {

    }

    @Override
    public void useCallService(double amount, int seconds) {

    }

    @Override
    public boolean isCardPhoneContract() {
        return false;
    }

    @Override
    public boolean isSubscription() {
        return true;
    }

    @Override
    public boolean isMixContract() {
        return false;
    }

    @Override
    double getSmsPrice() {
        return 0;
    }

    @Override
    double getMmsPrice() {
        return 0;
    }

    @Override
    double getCallPrice() {
        return 0;
    }

    @Override
    public double createBill() {
        return subscriptionFee;
    }
}
