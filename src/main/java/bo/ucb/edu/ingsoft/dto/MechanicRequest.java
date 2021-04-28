package bo.ucb.edu.ingsoft.dto;

public class MechanicRequest {
    private Integer idMechanic;
    private Integer idPerson;
    private Integer idCity;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String location;
    private String shopName;
    private String shopPhoneNumber;
    private String verification_path;

    public MechanicRequest() {
    }

    public Integer getIdMechanic() {
        return idMechanic;
    }

    public void setIdMechanic(Integer idMechanic) {
        this.idMechanic = idMechanic;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPhoneNumber() {
        return shopPhoneNumber;
    }

    public void setShopPhoneNumber(String shopPhoneNumber) {
        this.shopPhoneNumber = shopPhoneNumber;
    }

    public String getVerification_path() {
        return verification_path;
    }

    public void setVerification_path(String verification_path) {
        this.verification_path = verification_path;
    }

    @Override
    public String toString() {
        return "MechanicRequest{" +
                "idMechanic=" + idMechanic +
                ", idPerson=" + idPerson +
                ", idCity=" + idCity +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", location='" + location + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPhoneNumber='" + shopPhoneNumber + '\'' +
                ", verification_path='" + verification_path + '\'' +
                '}';
    }
}
