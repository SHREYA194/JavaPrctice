package oopsPractice;

/**
 * has-a relationship
 * class have am entity reference
 */

public class AggregationPractice {
    public static void main(String[] args) {
        Address address1 = new Address("city 1", "state 1", "country 1");
        Address address2 = new Address("city 2", "state 2", "country 2");

        Employee employee1 = new Employee(1, "name 1", address1);
        Employee employee2 = new Employee(2, "name 2", address2);
        Employee employee3 = new Employee(3, "name 3", address1);

        System.out.println(employee1 + "\n" + employee2 + "\n" + employee3);
    }
}


class Address {
    String city,state,country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {
    int id;
    String name;
    Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
