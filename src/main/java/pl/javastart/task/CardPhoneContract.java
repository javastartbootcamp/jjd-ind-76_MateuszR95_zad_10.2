package pl.javastart.task;

public class CardPhoneContract extends Contract {

    public double accountBalance;
    private double smsPrice;
    private double mmsPrice;
    private double callPrice;

    public CardPhoneContract(double accountBalance, double smsPrice, double mmsPrice, double callPrice) {
        this.accountBalance = accountBalance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.callPrice = callPrice;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public double getMmsPrice() {
        return mmsPrice;
    }

    public void setMmsPrice(double mmsPrice) {
        this.mmsPrice = mmsPrice;
    }

    public double getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(double callPrice) {
        this.callPrice = callPrice;
    }

    @Override
    public boolean canSendSms() {
        return smsPrice <= accountBalance;
    }

    @Override
    public boolean canSendMms() {
        return mmsPrice <= accountBalance;
    }

    @Override
    public boolean canCall(int seconds) {
        return seconds * callPrice <= accountBalance;
    }

    @Override
    public double getRemainingAccountBalance() {
        return accountBalance;
    }

    @Override
    public void useSmsService(double amount) {
        accountBalance -= amount;
    }

    @Override
    public void useMmsService(double amount) {
        accountBalance -= amount;

    }

    @Override
    public void useCallService(double amount, int seconds) {
        accountBalance -= amount * seconds;
    }

    @Override
    public double createBill() {
        return 0;
    }

    @Override
    public boolean isCardPhoneContract() {
        return true;
    }

    @Override
    public boolean isSubscription() {
        return false;
    }

    @Override
    public boolean isMixContract() {
        return false;
    }

}