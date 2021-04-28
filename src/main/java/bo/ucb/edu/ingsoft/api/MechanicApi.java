package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.MechanicBl;
import bo.ucb.edu.ingsoft.dto.MechanicSellerRequest;
import bo.ucb.edu.ingsoft.dto.MechanicSimpleRequest;
import bo.ucb.edu.ingsoft.dto.QualifyMechanicRequest;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/mechanic")
public class MechanicApi {
    private MechanicBl mechanicBl;

    @Autowired
    public MechanicApi(MechanicBl mechanicBl){
        this.mechanicBl = mechanicBl;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MechanicSimpleRequest> mechanics(HttpServletRequest request) {
        List<MechanicSimpleRequest> mechanic=mechanicBl.mechanics();
        return mechanic;
    }

    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public QualifyMechanicRequest qualifyMechanic(@RequestBody QualifyMechanicRequest qualifyMechanicRequest , HttpServletRequest request){
        TransactionUtil transactionUtil = new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
        return mechanicBl.qualifyMechanic(qualifyMechanicRequest,transaction);
    }












    @GetMapping(path = "/{sellerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MechanicSellerRequest mechanicSeller(@PathVariable String sellerId) {
        return mechanicBl.mechanicSeller(Integer.parseInt(sellerId));
    }

}
