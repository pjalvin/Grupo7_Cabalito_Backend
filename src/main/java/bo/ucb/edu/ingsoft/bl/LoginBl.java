package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.LoginDao;
import bo.ucb.edu.ingsoft.dao.SellerDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.util.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class LoginBl {
    private LoginDao loginDao;
    private TransactionDao transactionDao;
    private UserDao userDao;
    private SellerDao sellerDao;

    @Autowired
    public LoginBl(LoginDao loginDao, TransactionDao transactionDao, UserDao userDao, SellerDao sellerDao) {
        this.loginDao = loginDao;
        this.transactionDao = transactionDao;
        this.userDao=userDao;
        this.sellerDao=sellerDao;
    }

    @Autowired
    PasswordEncoder encoder;

    public UserRequest SignUp(UserRequest userRequest, Transaction transaction){

        UserRequest userInfo=loginDao.findByEmail(userRequest.getEmail());
        if(userInfo==null){
            User user=new User();
            user.setEmail(userRequest.getEmail());
            user.setPassword(encoder.encode(userRequest.getPassword()));
            user.setTransaction(transaction);
            userDao.createUser(user);
            UserRequest userSeller=new UserRequest();
            Integer userId=transactionDao.getLastInsertId();
            userSeller.setIdUser(userId);
            JWTUtil jwtUtil=new JWTUtil();
            String token = jwtUtil.getJWTToken(userSeller);
            userRequest.setToken(token);
            return userRequest;
        }
        else{
            throw new RuntimeException("Ya existe el usuario");
        }
    }
    public UserRequest SignIn(UserRequest userRequest, Transaction transaction){

        UserRequest userInfo=loginDao.findByEmail(userRequest.getEmail());
        if(userInfo!=null){
            if(encoder.matches(userRequest.getPassword(),userInfo.getPassword())){
                UserRequest userSeller=sellerDao.findByUserId(userInfo.getIdUser());
                userInfo.setIdSeller(userSeller.getIdSeller());
                userInfo.setPassword("");
                JWTUtil jwtUtil=new JWTUtil();
                String token = jwtUtil.getJWTToken(userInfo);
                userInfo.setToken(token);
                return userInfo;
            }
            else{
                throw new RuntimeException("Error en las credenciales");
            }
        }
        else{
            throw new RuntimeException("No existe el usuario");
        }
    }
}
