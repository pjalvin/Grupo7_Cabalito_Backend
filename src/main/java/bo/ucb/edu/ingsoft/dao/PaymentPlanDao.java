package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentPlanDao {
    public List<PaymentPlanRequest> getPaymentPlan();
    public Integer getTimePlan(Integer idPlan);
}
