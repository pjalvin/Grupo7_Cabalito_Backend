package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.PublicationSimpleRequest;
import bo.ucb.edu.ingsoft.dto.SellerRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.Publication;
import bo.ucb.edu.ingsoft.model.Seller;
import bo.ucb.edu.ingsoft.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SellerDao {
    public SellerRequest findBySellerId(Integer sellerId);
    public UserRequest findByUserId(Integer userId);

    public SellerRequest findSeller(Integer userId);

    public SellerRequest findBySellerIdP(Integer sellerId);



    public void createSeller(Seller seller);
    public void updateSeller(Seller seller);
    public void updateImage(Seller seller);
    public List<PublicationSimpleRequest> publications(Integer idSeller, Integer i, Integer n);

    List<SellerRequest> getSellers(Integer  i, Integer n,String search);
    Integer getTotalSellers(String search);
    public void deleteUser(User user);
}
