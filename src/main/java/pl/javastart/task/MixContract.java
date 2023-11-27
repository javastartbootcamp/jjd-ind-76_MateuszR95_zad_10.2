package pl.javastart.task;

public class MixContract extends Contract {

    private double additionalAccountBalance;
    private int smsLimit;
    private int mmsLimit;
    private int callLimit;
    private double smsPrice;
    private double mmsPrice;
    private double callPrice;
    private int remainingSms;
    private int remainingMms;
    private int remainingCallSeconds;

    public MixContract(double additionalAccountBalance, int smsLimit, int mmsLimit, int callLimit, double smsPrice, double mmsPrice, double callPrice) {
        this.additionalAccountBalance = additionalAccountBalance;
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.callLimit = callLimit;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.callPrice = callPrice;
        this.remainingSms = smsLimit;
        this.remainingMms = mmsLimit;
        this.remainingCallSeconds = callLimit;
    }

    @Override
    public boolean canSendSms() {
        return remainingSms > 0 || getSmsPrice() <= additionalAccountBalance;
    }

    @Override
    public boolean canSendMms() {
        return remainingMms > 0 || getMmsPrice() <= additionalAccountBalance;
    }

    @Override
    public boolean canCall(int seconds) {
        return remainingCallSeconds >= seconds || getCallPrice() * seconds <= additionalAccountBalance;
    }

    @Override
    public double getRemainingAccountBalance() {
        return additionalAccountBalance;
    }

    @Override
    public void useSmsService(double amount) {
        if (remainingSms > 0) {
            remainingSms--;
        } else if (remainingSms == 0 && additionalAccountBalance >= amount) {
            additionalAccountBalance -= amount;
        }
    }

    @Override
    public void useMmsService(double amount) {
        if (remainingMms > 0) {
            remainingMms--;
        } else if (remainingMms == 0 && additionalAccountBalance >= amount) {
            additionalAccountBalance -= amount;
        }
    }

    @Override
    public void useCallService(double amount, int seconds) {
        if (remainingCallSeconds >= seconds) {
            remainingCallSeconds -= seconds;
        } else if (additionalAccountBalance >= amount * seconds) {
            additionalAccountBalance -= amount * seconds;
        }

    }

    @Override
    public double createBill() {
        return 0;
    }

    @Override
    public boolean isCardPhoneContract() {
        return false;
    }

    @Override
    public boolean isSubscription() {
        return false;
    }

    @Override
    public boolean isMixContract() {
        return true;
    }

    @Override
    double getSmsPrice() {
        return smsPrice;
    }

    @Override
    double getMmsPrice() {
        return mmsPrice;
    }

    @Override
    double getCallPrice() {
        return callPrice;
    }

    public int getSmsLimit() {
        return smsLimit;
    }

    public void setSmsLimit(int smsLimit) {
        this.smsLimit = smsLimit;
    }

    public int getMmsLimit() {
        return mmsLimit;
    }

    public void setMmsLimit(int mmsLimit) {
        this.mmsLimit = mmsLimit;
    }

    public int getCallLimit() {
        return callLimit;
    }

    public void setCallLimit(int callLimit) {
        this.callLimit = callLimit;
    }

    public int getRemainingSms() {
        return remainingSms;
    }

    public void setRemainingSms(int remainingSms) {
        this.remainingSms = remainingSms;
    }

    public int getRemainingMms() {
        return remainingMms;
    }

    public void setRemainingMms(int remainingMms) {
        this.remainingMms = remainingMms;
    }

    public int getRemainingCallSeconds() {
        return remainingCallSeconds;
    }

    public void setRemainingCallMinutes(int remainingCallMinutes) {
        this.remainingCallSeconds = remainingCallMinutes;
    }
}
