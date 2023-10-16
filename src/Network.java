import devices.*;
public class Network {
    public static void main(String[] args) {
        // Create some devices
        Phone phone1 = new Phone(1);
        Phone phone2 = new Phone(2);
        Computer computer1 = new Computer(1);
        Computer computer2 = new Computer(2);
        Router router1 = new Router(1);
        Router router2 = new Router(2);

        // Connect some devices
        phone1.connect(phone2);
        phone2.connect(computer1);
        computer1.connect(router1);
        router1.connect(computer2);

        // Test communication between devices
        System.out.println("\nPhone1 -> Computer2: " + phone1.canCommunicateWith(computer2));
        System.out.println("--------------------------");
        System.out.println("\nComputer2 -> Phone1: " + computer2.canCommunicateWith(phone1));
        System.out.println("--------------------------");
        System.out.println("\nPhone2 -> Router2: " + phone2.canCommunicateWith(router2));
    }
}
