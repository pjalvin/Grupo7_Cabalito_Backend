package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.MechanicBl;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.model.Mechanic;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import bo.ucb.edu.ingsoft.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
        UserUtil userUtil=new UserUtil();
        Integer idSeller=userUtil.getIdSeller();
        List<MechanicSimpleRequest> mechanic=mechanicBl.mechanics(idSeller);
        return mechanic;
    }

    @RequestMapping(path="/qualify",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public QualifyMechanicRequest qualifyMechanic(@RequestBody QualifyMechanicRequest qualifyMechanicRequest , HttpServletRequest request){
        TransactionUtil transactionUtil = new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
            UserUtil userUtil=new UserUtil();
        qualifyMechanicRequest.setIdUser(userUtil.getIdUser());
        return mechanicBl.qualifyMechanic(qualifyMechanicRequest,transaction);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public MechanicRequest create(@RequestBody MechanicRequest mechanicRequest, HttpServletRequest request) {
        TransactionUtil transactionUtil=new TransactionUtil();
        UserUtil userUtil=new UserUtil();
        Integer idSeller=userUtil.getIdSeller();
        Transaction transaction = transactionUtil.createTransaction(request);
        mechanicRequest.setIdSeller(idSeller);
        mechanicBl.create(mechanicRequest,transaction);
        return mechanicRequest;
    }
    @RequestMapping(path="/image",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadImages(@RequestParam MultipartFile images, @RequestParam Integer idMechanic, HttpServletRequest request){
        TransactionUtil transactionUtil=new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
        mechanicBl.uploadImages(images,idMechanic,transaction);
        return "Imagenes subidas correctamente";
    }


    @GetMapping(path = "/seller", produces = MediaType.APPLICATION_JSON_VALUE)
    public MechanicSellerRequest mechanicSeller(HttpServletRequest request) {
        UserUtil userUtil=new UserUtil();
        Integer idSeller=userUtil.getIdSeller();
        return mechanicBl.mechanicSeller(idSeller);
    }

    @RequestMapping(path="/paymentPlan",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateMechanicPlan(@RequestParam Integer idPlan, HttpServletRequest request){
        TransactionUtil transactionUtil = new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
        UserUtil userUtil=new UserUtil();
        Integer idSeller=userUtil.getIdSeller();
        mechanicBl.updateMechanicPlan(transaction,idSeller,idPlan);
    }

    @GetMapping(path = "/adm/mechanics", produces = MediaType.APPLICATION_JSON_VALUE)
    public MechanicAdminResponse getMechanics(@RequestParam(required = true) Integer i,
                                              @RequestParam(required = false) String search,
                                              @RequestParam(required = true) Integer n){
        return mechanicBl.getMechanics(i,n,search);
    }

    @GetMapping(path = "/adm/mechanicShop", produces = MediaType.APPLICATION_JSON_VALUE)
    public MechanicAdminResponse getMechanicShop(@RequestParam(required = true) Integer i,
                                                 @RequestParam(required = false) String search,
                                                 @RequestParam(required = true) Integer n){
        return mechanicBl.getMechanicShop(i,n,search);
    }

    @RequestMapping(path="/status",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateMechanicStatus(@RequestParam(required = true) Integer status,
                                     @RequestParam(required = true) Integer idSeller,
                                     HttpServletRequest request){
        TransactionUtil transactionUtil = new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
        mechanicBl.updateMechanicStatus(transaction,idSeller,status);
    }
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateMechanic(@RequestBody MechanicRequest mechanicRequest, HttpServletRequest request) {
        TransactionUtil transactionUtil = new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
        mechanicBl.update(mechanicRequest, transaction);
    }
}
