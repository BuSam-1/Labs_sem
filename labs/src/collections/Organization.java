package collections;

import java.util.Date;
import java.util.Objects;

public class Organization implements Comparable<Organization> {
    private static int lastId = 0;
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Double annualTurnover;
    private Long employeesCount;
    private OrganizationType type;
    private Address officalAddress;
    public Organization(String name, Coordinates coordinates, Double annualTurnover, Long employeesCount, OrganizationType type, Address postalAddress) {
        this.id = lastId;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officalAddress = postalAddress;

    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Double annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getOfficialAddress() {
        return officalAddress;
    }




    public void setOfficialAddress(Address officialAddress) {
        this.officalAddress = officialAddress;
    }
    @Override
    public int compareTo(Organization o) {
        return this.getId() - o.getId();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(annualTurnover, that.annualTurnover) && Objects.equals(employeesCount, that.employeesCount) && type == that.type && Objects.equals(officalAddress, that.officalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, annualTurnover, employeesCount, type, officalAddress);
    }

    @Override
    public String toString(){
        return "Id: " + getId() + ",\nName: " +getName()+
                ",\nCoordinates:\n{ " + "x: "+getCoordinates().getX()+",\ny: "+
                getCoordinates().getY() + "\n},\nCreation Date: " + getCreationDate()
                + ",\nAnnual Turnover: " + getAnnualTurnover() + ",\nEmployees Count: "
                +getEmployeesCount() +",\nType: " + getType() + ",\nOfficial Address: {\nStreet: " +
                getOfficialAddress().getStreet() +",\nZipCode: " + getOfficialAddress().getZipCode()+
                "\n}\n";
    }
}
