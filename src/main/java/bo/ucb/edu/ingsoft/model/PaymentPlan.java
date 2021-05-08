package bo.ucb.edu.ingsoft.model;

public class PaymentPlan {
    private Integer idPaymentPlan;
    private String name;
    private String planCode;
    private float total;
    private Integer time;

    public PaymentPlan() {
    }

    public Integer getIdPaymentPlan() {
        return idPaymentPlan;
    }

    public void setIdPaymentPlan(Integer idPaymentPlan) {
        this.idPaymentPlan = idPaymentPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PaymentPlan{" +
                "idPaymentPlan=" + idPaymentPlan +
                ", name='" + name + '\'' +
                ", planCode='" + planCode + '\'' +
                ", total=" + total +
                ", time=" + time +
                '}';
    }
}
