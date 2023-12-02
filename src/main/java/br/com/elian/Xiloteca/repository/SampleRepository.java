package br.com.elian.Xiloteca.repository;

import br.com.elian.Xiloteca.entity.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SampleRepository extends MongoRepository<Sample, String> {
    public List<Sample> findByCod();
    public List<Sample> findByFamily();
    public List<Sample> findBySciName();
    public List<Sample> findByComName();
}
