package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.model.*;
import bo.ucb.edu.ingsoft.util.StorageUtil;
import bo.ucb.edu.ingsoft.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MechanicBl {
    private MechanicDao mechanicDao;
    private StarDao starDao;
    private TransactionDao transactionDao;
    private PersonDao personDao;
    private PaymentPlanDao paymentPlanDao;

    @Autowired
    public MechanicBl(MechanicDao mechanicDao,StarDao starDao, TransactionDao transactionDao, PaymentPlanDao paymentPlanDao){
        this.mechanicDao = mechanicDao;
        this.starDao = starDao;
        this.transactionDao = transactionDao;
        this.paymentPlanDao = paymentPlanDao;
    }

    public List<MechanicSimpleRequest> mechanics(Integer idSeller){
        List<MechanicSimpleRequest> mechanic=mechanicDao.mechanics();
        List<StarRequest> stars=mechanicDao.getStars(idSeller);
        for(int i=0;i<mechanic.size();i++)
        {
            for(int j=0;j<stars.size();j++)
            {
                if(mechanic.get(i).getIdMechanic()==stars.get(j).getIdMechanic()){
                    mechanic.get(i).setQualified(true);
                    break;
                }
            }
        }
        return mechanic;
    }

    public QualifyMechanicRequest qualifyMechanic(QualifyMechanicRequest qualifyMechanicRequest, Transaction transaction){

        Star star = new Star();
        UserUtil userUtil=new UserUtil();
        star.setIdSeller(userUtil.getIdUser());
        star.setIdMechanic(qualifyMechanicRequest.getIdMechanic());
        star.setScore(qualifyMechanicRequest.getScore());
        star.setTransaction(transaction);
        starDao.createStar(star);

        Mechanic mechanic = new Mechanic();

        mechanic.setStars(qualifyMechanicRequest.getScore());
        mechanic.setIdMechanic(qualifyMechanicRequest.getIdMechanic());
        mechanicDao.starsValue(mechanic);
        return qualifyMechanicRequest;
    }
    public MechanicRequest create(MechanicRequest mechanicRequest, Transaction transaction){
        Mechanic mechanic = new Mechanic();
        mechanic.setIdSeller(mechanicRequest.getIdSeller());
        mechanic.setIdCity(mechanicRequest.getIdCity());

        mechanic.setLocation(mechanicRequest.getLocation());
        mechanic.setShopName(mechanicRequest.getShopName());
        mechanic.setShopPhoneNumber(mechanicRequest.getShopPhoneNumber());
        mechanic.setVerificationPath(mechanicRequest.getVerificationPath());

        mechanic.setTransaction(transaction);
        mechanicDao.createMechanic(mechanic);
        int mechanicId = transactionDao.getLastInsertId();
        mechanicRequest.setIdMechanic(mechanicId);
        return mechanicRequest;

    }
    public void uploadImages(MultipartFile images, Integer idMechanic, Transaction transaction){
        StorageUtil storageUtil= new StorageUtil();
        String nombre=storageUtil.upload(images,"imageMechanic");
        Mechanic mechanic = new Mechanic();
        mechanic.setIdMechanic(idMechanic);
        mechanic.setVerificationPath(nombre);
        mechanicDao.updateImage(mechanic);
    }

    public MechanicSellerRequest mechanicSeller(Integer idSeller){
        return mechanicDao.mechanicSeller(idSeller);
    }

    public void updateMechanicPlan(Transaction transaction,Integer idSeller,Integer idPlan){
        Integer idMechanic = mechanicDao.findByMechanicId(idSeller);
        Mechanic mechanic = new Mechanic();
        Date datePayment;
        Calendar c = Calendar.getInstance();
        Integer timePlan;
        mechanic.setIdMechanic(idMechanic);
        mechanic.setTransaction(transaction);
        if(idPlan != null){
           timePlan = paymentPlanDao.getTimePlan(idPlan);
           c.add(Calendar.DAY_OF_YEAR, timePlan);
           datePayment = c.getTime();
           mechanic.setDueDatePayment(datePayment);
           mechanicDao.updateMechanicPlan(mechanic);
        }
    }

    public List<MechanicRequest> getMechanics(){
        return mechanicDao.getMechanics();
    }

    public List<MechanicRequest> getMechanicShop(){
        return mechanicDao.getMechanicShop();
    }

    public void updateMechanicStatus(Transaction transaction,Integer idSeller,Integer status){
        Integer idMechanic = mechanicDao.findByMechanicId(idSeller);
        Mechanic mechanic = new Mechanic();
        mechanic.setTransaction(transaction);
        mechanic.setStatus(status);
        mechanic.setIdMechanic(idMechanic);
        mechanicDao.updateMechanicStatus(mechanic);
    }
}
