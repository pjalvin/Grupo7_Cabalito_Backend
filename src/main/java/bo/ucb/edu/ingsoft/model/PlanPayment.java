package bo.ucb.edu.ingsoft.model;
public class PlanPayment {
    private int idPaymentPlan;
    private String name;
    private float total;
    private String time;

    public PlanPayment() {
    }

    public int getIdPaymentPlan() {
        return idPaymentPlan;
    }

    public void setIdPaymentPlan(int idPaymentPlan) {
        this.idPaymentPlan = idPaymentPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

