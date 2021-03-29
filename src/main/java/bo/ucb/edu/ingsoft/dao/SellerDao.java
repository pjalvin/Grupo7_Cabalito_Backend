package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.SellerRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.Seller;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SellerDao {
    public SellerRequest findBySellerId(Integer sellerId);
    public UserRequest findByUserId(Integer userId);
    public SellerRequest findSeller(Integer userId);

    public void createSeller(Seller seller);
    public void updateSeller(Seller seller);
    public void updateImage(Seller seller);
}
