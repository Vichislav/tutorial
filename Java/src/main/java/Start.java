public class Start {
    public static void main (String[] args) {
        Computer apple = new Computer();

        apple.setMemory(1000);
        apple.setCpu(2500);
        apple.setName("Macbook10");

        System.out.println("Парамерты компьютера");

        System.out.print("Memory = ");
        apple.getMemory();

        System.out.print("Cpu = ");
        apple.getCpu();

        System.out.print("Имя = ");
        apple.getName();

        Printer hp = new Printer(2500, "hp");

        System.out.println("Парамерты принтера");

        System.out.print("Цена принтера ");
        hp.getPrice();

        System.out.print("Марка принтера ");
        hp.getName();

    }
}