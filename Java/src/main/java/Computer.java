public class Computer {

    private int memory;
    private int cpu;
    private String name;

    void setMemory (int m) {
        memory = m;
    }
    void setCpu (int c) {
        cpu = c;
    }
    void setName (String n) {
        name = n;
    }

    void getMemory () {
        System.out.println(memory);
    }
    void getCpu () {
        System.out.println(cpu);
    }
    void getName () {
        System.out.println(name);
    }
}

