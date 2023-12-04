package br.com.elian.Xiloteca.repository;

import br.com.elian.Xiloteca.entity.Sample;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SampleRepository extends MongoRepository<Sample, String>, PagingAndSortingRepository<Sample, String> {
//    @Query("{cod}: /?0/i}")
    @Query("{cod: {$regex: ?0, $options: 'i'}}")
    public List<Sample> findByCod(String cod, Pageable pageable);
    @Query("{family: {$regex: ?0, $options: 'i'}}")
    public List<Sample> findByFamily(String family, Pageable pageable);
    @Query("{sciName: {$regex: ?0, $options: 'i'}}")
    public List<Sample> findBySciName(String sciName, Pageable pageable);
    @Query("{comName: {$regex: ?0, $options: 'i'}}")
    public List<Sample> findByComName(String comName, Pageable pageable);
}
