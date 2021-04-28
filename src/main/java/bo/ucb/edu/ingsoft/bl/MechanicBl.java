package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.MechanicDao;
import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.StarDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
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
        Person person = new Person();
        Mechanic mechanic = new Mechanic();
        person.setFirstName(mechanicRequest.getFirstName());
        person.setLastName(mechanicRequest.getLastName());
        person.setPhoneNumber(mechanicRequest.getPhoneNumber());
        person.setTransaction(transaction);
        personDao.createPerson(person);
        int personId=transactionDao.getLastInsertId();
        mechanic.setVerification_path(mechanicRequest.getVerification_path());
        mechanic.setIdPerson(personId);
        mechanic.setTransaction(transaction);
        mechanicDao.createMechanic(mechanic);
        int mechanicId = transactionDao.getLastInsertId();
        mechanicRequest.setIdMechanic(mechanicId);
        return mechanicRequest;

    }

}
