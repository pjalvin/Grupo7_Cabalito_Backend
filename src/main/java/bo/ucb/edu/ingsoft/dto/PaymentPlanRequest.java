package bo.ucb.edu.ingsoft.dto;

public class PaymentPlanRequest {
    private Integer idPaymentPlan;
    private String namePlan;
    private String planCode;

    public PaymentPlanRequest() {
    }

    public Integer getIdPaymentPlan() {
        return idPaymentPlan;
    }

    public void setIdPaymentPlan(Integer idPaymentPlan) {
        this.idPaymentPlan = idPaymentPlan;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    @Override
    public String toString() {
        return "PaymentPlanRequest{" +
                "idPaymentPlan=" + idPaymentPlan +
                ", namePlan='" + namePlan + '\'' +
                ", planCode='" + planCode + '\'' +
                '}';
    }
}
