package collections;

public class Address {
    private final String street;
    private final String zipCode;

    public Address(String street, String zipCode){
        this.street = street;
        this.zipCode = zipCode;
    }


    public String getStreet() {
        return street;
    }


    public String getZipCode() {
        return zipCode;
    }
}
