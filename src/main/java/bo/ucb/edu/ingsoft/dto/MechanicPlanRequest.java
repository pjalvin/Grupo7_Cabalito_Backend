package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class MechanicPlanRequest {
    private Integer idMechanic;
    private Integer idCity;
    private Integer idSeller;
    private String location;
    private String shopName;
    private String shopPhoneNumber;
    private String verificationPath;
    private Date dueDatePayment;

    public MechanicPlanRequest() {
    }

    public Integer getIdMechanic() {
        return idMechanic;
    }

    public void setIdMechanic(Integer idMechanic) {
        this.idMechanic = idMechanic;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public Integer getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Integer idSeller) {
        this.idSeller = idSeller;
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

    public String getVerificationPath() {
        return verificationPath;
    }

    public void setVerificationPath(String verificationPath) {
        this.verificationPath = verificationPath;
    }

    public Date getDueDatePayment() {
        return dueDatePayment;
    }

    public void setDueDatePayment(Date dueDatePayment) {
        this.dueDatePayment = dueDatePayment;
    }

    @Override
    public String toString() {
        return "MechanicPlanRequest{" +
                "idMechanic=" + idMechanic +
                ", idCity=" + idCity +
                ", idSeller=" + idSeller +
                ", location='" + location + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPhoneNumber='" + shopPhoneNumber + '\'' +
                ", verificationPath='" + verificationPath + '\'' +
                ", dueDatePayment=" + dueDatePayment +
                '}';
    }
}
