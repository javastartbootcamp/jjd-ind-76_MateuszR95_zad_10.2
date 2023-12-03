package pl.javastart.task;

public class Phone {

    private Contract contract;
    private int smsCounter = 0;
    private int mmsCounter = 0;
    private int callCounter = 0;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    public void sendSms() {
        if (contract.canSendSms()) {
            smsCounter++;
            contract.useSmsService();
            System.out.println("SMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }

    }

    public void call(int seconds) {
        int callDuration = contract.useCallService(seconds);
        if (callDuration == seconds) {
            callCounter += seconds;
            System.out.println("Rozmowa trwała: " + seconds + " sekund");
        } else if (callDuration > 0) {
            callCounter += callDuration;
            System.out.println("Rozmowa przerwana po " + callDuration + " sekundach");
        } else {
            System.out.println("Nie można zrealizować rozmowy");

        }
    }

    public void sendMms() {
        if (contract.canSendMms()) {
            mmsCounter++;
            contract.useMmsService();
            System.out.println("MMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać MMSa");

        }
    }

    public void printAccountState() {
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + smsCounter);
        System.out.println("Wysłanych MMSów: " + mmsCounter);
        System.out.println("Liczba sekund rozmowy: " + callCounter);
        System.out.println(contract.getAccountState());

    }

    public Contract getContract() {
        return contract;
    }

    private void setContract(Contract contract) {
        this.contract = contract;
    }

    int getSmsCounter() {
        return smsCounter;
    }

    private void setSmsCounter(int smsCounter) {
        this.smsCounter = smsCounter;
    }

    int getMmsCounter() {
        return mmsCounter;
    }

    private void setMmsCounter(int mmsCounter) {
        this.mmsCounter = mmsCounter;
    }

    int getCallCounter() {
        return callCounter;
    }

    private void setCallCounter(int callCounter) {
        this.callCounter = callCounter;
    }
}
