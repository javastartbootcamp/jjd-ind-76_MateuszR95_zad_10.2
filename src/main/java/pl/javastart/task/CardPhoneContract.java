package pl.javastart.task;

public class CardPhoneContract extends Contract {

    public double accountBalance;
    protected double smsPrice;
    protected double mmsPrice;
    protected double callPricePerMinute;

    public CardPhoneContract(double accountBalance, double smsPrice, double mmsPrice, double callPricePerMinute) {
        this.accountBalance = accountBalance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.callPricePerMinute = callPricePerMinute;
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
        return callPricePerMinute;
    }

    public void setCallPrice(double callPrice) {
        this.callPricePerMinute = callPrice;
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
    public double getRemainingAccountBalance() {
        return accountBalance;
    }

    @Override
    public void useSmsService() {
        accountBalance -= smsPrice;
    }

    @Override
    public void useMmsService() {
        accountBalance -= mmsPrice;

    }

    @Override
    public int useCallService(int seconds) {
        double availableSecondsForCall = accountBalance / callPricePerMinute * 60;
        if (seconds <= availableSecondsForCall) {
            accountBalance -= seconds * callPricePerMinute / 60;
            return seconds;
        } else {
            int secondsToUse = (int) availableSecondsForCall;
            accountBalance = 0;
            return secondsToUse;
        }
    }

    @Override
    public String getAccountState() {
        return String.format("Na koncie zostało: %.2f zł%n", getRemainingAccountBalance());
    }

    @Override
    public double createBill() {
        return 0;
    }

}