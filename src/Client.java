public class Client {

    private static int nextId = 1;
    private final int id;

    private String name;
    private int age;

    public Client(String name, int age) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void printInfo() {
        System.out.println("Client -> ID: " + id +
                ", Name: " + name +
                ", Age: " + age);
    }
    public String toString() {
        return "Client { id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                " }";
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return id == client.id;
    }
    public int hashCode() {
        return Integer.hashCode(id);
    }
}


