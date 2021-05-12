package bo.ucb.edu.ingsoft.dto;

import java.util.List;

public class UsuariosAdmiResponse {
    int total;
    List<SellerRequest> sellers;
    public UsuariosAdmiResponse(){}
    public UsuariosAdmiResponse(int total, List<SellerRequest> sellers) {
        this.total = total;
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "UsuariosAdmiResponse{" +
                "total=" + total +
                ", sellers=" + sellers +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<SellerRequest> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerRequest> sellers) {
        this.sellers = sellers;
    }
}
