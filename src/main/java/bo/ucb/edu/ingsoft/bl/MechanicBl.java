package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.MechanicDao;
import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.StarDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.MechanicSellerRequest;
import bo.ucb.edu.ingsoft.dto.MechanicRequest;
import bo.ucb.edu.ingsoft.dto.MechanicSimpleRequest;
import bo.ucb.edu.ingsoft.dto.QualifyMechanicRequest;
import bo.ucb.edu.ingsoft.dto.SellerRequest;
import bo.ucb.edu.ingsoft.model.*;
import bo.ucb.edu.ingsoft.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicBl {
    private MechanicDao mechanicDao;
    private StarDao starDao;
    private TransactionDao transactionDao;
    private PersonDao personDao;

    @Autowired
    public MechanicBl(MechanicDao mechanicDao,StarDao starDao, TransactionDao transactionDao){
        this.mechanicDao = mechanicDao;
        this.starDao = starDao;
        this.transactionDao = transactionDao;
    }

    public List<MechanicSimpleRequest> mechanics(){
        List<MechanicSimpleRequest> mechanic=mechanicDao.mechanics();
        return mechanic;
    }

    public QualifyMechanicRequest qualifyMechanic(QualifyMechanicRequest qualifyMechanicRequest, Transaction transaction){

        Star star = new Star();
        UserUtil userUtil=new UserUtil();
        star.setIdUser(userUtil.getIdUser());
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



    public MechanicSellerRequest mechanicSeller(Integer sellerId){
        return mechanicDao.mechanicSeller(sellerId);
    }
}
