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
            contract.useSmsService(contract.getSmsPrice());
            System.out.println("SMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }

    }

    public void call(int seconds) {
        if (contract.canCall(seconds)) {
            callCounter += seconds;
            contract.useCallService(contract.getCallPrice(), seconds);
            System.out.println("Rozmowa trwała: " + seconds + " sekund");
        } else {
            System.out.println("Nie można zrealizować rozmowy");

        }
    }

    public void sendMms() {
        if (contract.canSendMms()) {
            mmsCounter++;
            contract.useMmsService(contract.getMmsPrice());
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
        if (contract.isCardPhoneContract()) {
            System.out.printf("Na koncie zostało: %.2f zł%n", contract.getRemainingAccountBalance());
        } else if (contract.isSubscription()) {
            System.out.printf("Rachunek. Do zapłaty: %.2f zł%n", contract.createBill());
        } else if (contract.isMixContract()) {
            MixContract mixContract = (MixContract) contract;
            System.out.println("Pozostałe SMSy: " + mixContract.getRemainingSms());
            System.out.println("Pozostałe MMSy: " + mixContract.getRemainingMms());
            System.out.println("Pozostałe sekundy rozmowy: " + mixContract.getRemainingCallSeconds());
            System.out.printf("Pozostały stan konta: %.2f zł%n", mixContract.getRemainingAccountBalance());
        }
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
