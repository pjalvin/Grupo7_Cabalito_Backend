package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

public class StarRequest {
    private Integer idStar;
    private Integer idSeller;
    private Integer idMechanic;

    public StarRequest() {
    }

    public Integer getIdStar() {
        return idStar;
    }

    public void setIdStar(Integer idStar) {
        this.idStar = idStar;
    }

    public Integer getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Integer idSeller) {
        this.idSeller = idSeller;
    }

    public Integer getIdMechanic() {
        return idMechanic;
    }

    public void setIdMechanic(Integer idMechanic) {
        this.idMechanic = idMechanic;
    }

    @Override
    public String toString() {
        return "StarRequest{" +
                "idStar=" + idStar +
                ", idSeller=" + idSeller +
                ", idMechanic=" + idMechanic +
                '}';
    }
}
