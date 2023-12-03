package pl.javastart.task;

public class MixContract extends CardPhoneContract {

    private int smsLimit;
    private int mmsLimit;
    private double callLimit;
    private int remainingSms;
    private int remainingMms;
    private double remainingCallMinutes;

    public MixContract(double accountBalance, int smsLimit, int mmsLimit, double callLimit, double smsPrice, double mmsPrice, double callPricePerMinute) {
        super(accountBalance, smsPrice, mmsPrice, callPricePerMinute);
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.callLimit = callLimit;
        this.remainingSms = smsLimit;
        this.remainingMms = mmsLimit;
        this.remainingCallMinutes = callLimit;
    }

    @Override
    public boolean canSendSms() {
        return remainingSms > 0 || smsPrice <= accountBalance;
    }

    @Override
    public boolean canSendMms() {
        return remainingMms > 0 || mmsPrice <= accountBalance;
    }

    @Override
    public double getRemainingAccountBalance() {
        return accountBalance;
    }

    @Override
    public void useSmsService() {
        if (remainingSms > 0) {
            remainingSms--;
        } else if (accountBalance >= smsPrice) {
            accountBalance -= smsPrice;
        }
    }

    @Override
    public void useMmsService() {
        if (remainingMms > 0) {
            remainingMms--;
        } else if (accountBalance >= mmsPrice) {
            accountBalance -= mmsPrice;
        }
    }

    @Override
    public int useCallService(int seconds) {
        double availableSecondsForCall = remainingCallMinutes * 60;

        double secondsFromLimit;
        double secondsFromBalance;

        if (availableSecondsForCall < seconds) {
            secondsFromLimit = availableSecondsForCall;
            if (seconds > availableSecondsForCall) {
                secondsFromBalance = seconds - availableSecondsForCall;
            } else {
                secondsFromBalance = 0;
            }
        } else {
            secondsFromLimit = seconds;
            secondsFromBalance = 0;
        }

        if (remainingCallMinutes * 60 >= secondsFromLimit) {
            remainingCallMinutes -= secondsFromLimit / 60.0;
        } else {
            remainingCallMinutes = 0;
        }

        double costFromBalance = secondsFromBalance * callPricePerMinute / 60;
        if (costFromBalance <= accountBalance) {
            accountBalance -= costFromBalance;
        } else {
            if (accountBalance / callPricePerMinute < secondsFromBalance) {
                secondsFromBalance = accountBalance / callPricePerMinute;
            }
            accountBalance = 0;
        }

        return (int) (secondsFromLimit + secondsFromBalance);
    }

    @Override
    public String getAccountState() {
        return "Pozostałe SMSy: " + getRemainingSms() +
                "\nPozostałe MMSy: " + getRemainingMms() +
                "\nPozostałe sekundy rozmowy: " + getRemainingCallSeconds() +
                String.format("\nPozostały stan konta: %.2f zł%n", getRemainingAccountBalance());

    }

    @Override
    public double createBill() {
        return 0;
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

    public double getCallLimit() {
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

    public double getRemainingCallSeconds() {
        return remainingCallMinutes;
    }

    public void setRemainingCallMinutes(double remainingCallMinutes) {
        this.remainingCallMinutes = remainingCallMinutes;
    }
}
