package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.MechanicBl;
import bo.ucb.edu.ingsoft.dto.MechanicSimpleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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



}
