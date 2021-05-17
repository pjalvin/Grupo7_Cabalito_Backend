package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.model.Mechanic;
import bo.ucb.edu.ingsoft.model.Star;
import bo.ucb.edu.ingsoft.model.Seller;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface MechanicDao {
    public Integer findByMechanicId(Integer idSeller);
    public List<MechanicSimpleRequest> mechanics();
    public List<StarRequest> getStars(Integer idSeller);
    public void qualifyMechanic(QualifyMechanicRequest qualifyMechanicRequest);

    public Mechanic stars (Integer idMechanic);

    public void starsValue(Mechanic mechanic);

    public void createMechanic(Mechanic mechanic);

    public void updateImage(Mechanic mechanic);

    public MechanicSellerRequest mechanicSeller(Integer idSeller);

    public void updateMechanicPlan(Mechanic mechanic);

    public void updateMechanicStatus(Mechanic mechanic);

    public MechanicRequest update(Mechanic mechanic);

    List<MechanicRequest> getMechanics();
    List<MechanicRequest> getMechanicShop();
}
