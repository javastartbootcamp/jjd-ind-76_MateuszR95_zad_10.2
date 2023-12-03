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
    public double getRemainingAccountBalance() {
        return 0;
    }

    @Override
    public void useSmsService() {

    }

    @Override
    public void useMmsService() {

    }

    @Override
    public int useCallService(int seconds) {
        return seconds;
    }

    @Override
    public String getAccountState() {
        return String.format("Rachunek. Do zapłaty: %.2f zł%n", createBill());
    }

    @Override
    public double createBill() {
        return subscriptionFee;
    }
}
