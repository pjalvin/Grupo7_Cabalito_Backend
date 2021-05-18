package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class MechanicRequest {
    private Integer idMechanic;
    private Integer idCity;
    private Integer idSeller;
    private String location;
    private String shopName;
    private String shopPhoneNumber;
    private Integer status;
    private Integer stars;
    private Integer starsCount;
    private String verificationPath;
    private Date dueDatePayment;

    public MechanicRequest() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(Integer starsCount) {
        this.starsCount = starsCount;
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
        return "MechanicRequest{" +
                "idMechanic=" + idMechanic +
                ", idCity=" + idCity +
                ", idSeller=" + idSeller +
                ", location='" + location + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPhoneNumber='" + shopPhoneNumber + '\'' +
                ", stars=" + stars +
                ", starsCount=" + starsCount +
                ", verificationPath='" + verificationPath + '\'' +
                ", dueDatePayment=" + dueDatePayment +
                '}';
    }
}
