package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        Phone phone = new Phone(new MixContract(2.0, 1, 1, 1.2, 0.1, 0.2, 0.2));

        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.call(120);
        phone.printAccountState();

        phone.call(480);
        phone.printAccountState();

    }
}
