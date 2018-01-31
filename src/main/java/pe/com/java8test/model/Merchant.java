package pe.com.java8test.model;

/**
 * Created on 30/01/2018.
 *
 * @author Entelgy
 */
public class Merchant {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
