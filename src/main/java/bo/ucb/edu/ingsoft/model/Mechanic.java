package bo.ucb.edu.ingsoft.model;

public class Mechanic {
    private Integer idMechanic;
    private Integer idSeller;
    private Integer idCity;
    private String location;
    private String shopName;
    private String shopPhoneNumber;
    private Integer stars;
    private Integer starsCount;
    private String verificationPath;
    private Integer status;
    private Transaction transaction;


    public Mechanic() {
    }

    public Integer getIdMechanic() {
        return idMechanic;
    }

    public void setIdMechanic(Integer idMechanic) {
        this.idMechanic = idMechanic;
    }

    public Integer getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Integer idSeller) {
        this.idSeller = idSeller;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "idMechanic=" + idMechanic +
                ", idSeller=" + idSeller +
                ", idCity=" + idCity +
                ", location='" + location + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPhoneNumber='" + shopPhoneNumber + '\'' +
                ", stars=" + stars +
                ", starsCount=" + starsCount +
                ", verificationPath='" + verificationPath + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
