package br.com.elian.Xiloteca.repository;

import br.com.elian.Xiloteca.entity.Handler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface HandlerRepository extends MongoRepository<Handler, String> {
    UserDetails findByUser(String user);
}
