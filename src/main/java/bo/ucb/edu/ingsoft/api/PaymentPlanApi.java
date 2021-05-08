package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.PaymentPlanBl;
import bo.ucb.edu.ingsoft.dto.PaymentPlanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/paymentPlan")
public class PaymentPlanApi {
    private PaymentPlanBl paymentPlanBl;

    @Autowired
    public PaymentPlanApi(PaymentPlanBl paymentPlanBl){
        this.paymentPlanBl = paymentPlanBl;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentPlanRequest> getPaymentPlan(){
        return paymentPlanBl.getPaymentPlan();
    }



}
