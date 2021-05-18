package bo.ucb.edu.ingsoft.dto;

import java.util.List;

public class MechanicAdminResponse {
    int total;
    List<MechanicRequest> mechanics;
    public MechanicAdminResponse(){}
    public MechanicAdminResponse(int total, List<MechanicRequest> mechanics) {
        this.total = total;
        this.mechanics = mechanics;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MechanicRequest> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<MechanicRequest> mechanics) {
        this.mechanics = mechanics;
    }

    @Override
    public String toString() {
        return "MechanicAdminResponse{" +
                "total=" + total +
                ", mechanics=" + mechanics +
                '}';
    }
}
