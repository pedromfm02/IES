package pedro.ies.lab3_1.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pedro.ies.lab3_1.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
