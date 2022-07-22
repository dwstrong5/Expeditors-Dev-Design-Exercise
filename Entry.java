public class Entry {

    private String first;
    private String last;
    private String address;
    private String city;
    private String state;
    private int age;

    
    public Entry(String first, String last, String address, String city, String state, int age) {
        this.first = first;
        this.last = last;
        this.address = address;
        this.city = city;
        this.state = state;
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    public void printToString() {
        System.out.printf("\t%s - %s - %s - %s - %s - %d\n", first, last, address, city, state, age);
    }
}
