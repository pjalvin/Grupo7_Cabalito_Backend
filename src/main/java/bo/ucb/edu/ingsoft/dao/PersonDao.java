package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Person;
import bo.ucb.edu.ingsoft.model.Publication;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
    public Person findByPersonId(Integer personId);
    public void createPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Person person);
}
