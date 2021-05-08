package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PaymentPlanDao;
import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentPlanBl {
    private PaymentPlanDao paymentPlanDao;

    @Autowired
    public PaymentPlanBl(PaymentPlanDao paymentPlanDao){
        this.paymentPlanDao = paymentPlanDao;
    }

    public List<PaymentPlanRequest> getPaymentPlan(){
        return paymentPlanDao.getPaymentPlan();
    }
}
