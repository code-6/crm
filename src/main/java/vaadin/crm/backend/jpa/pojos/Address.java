package vaadin.crm.backend.jpa.pojos;

import javax.persistence.Entity;
import java.util.Objects;

//@Entity(name = "addresses")
public class Address extends AbstractEntity {
    private String country;
    private String city;
    private String street;
    private String number;

    public Address() {
        super();
    }

    public Address(String country, String city, String street, String number) {
        super();
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String assembleFullAddress(){
        return country+", "+city+", "+street+" st., "+"№ "+number+" ";
    }

    //region getters/setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    //endregion

    //region toString/equals/hasCode
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", "+assembleFullAddress()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getNumber(), address.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCountry(), getCity(), getStreet(), getNumber());
    }
    //endregion
}
