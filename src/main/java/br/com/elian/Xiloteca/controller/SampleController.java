package br.com.elian.Xiloteca.controller;

import br.com.elian.Xiloteca.entity.Sample;
import br.com.elian.Xiloteca.entity.dto.SampleDTO;
import br.com.elian.Xiloteca.service.SampleService;
import com.mongodb.internal.authentication.SaslPrep;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @Autowired
    SampleService sampleService;

    @GetMapping("find")
    public ResponseEntity<List<Sample>> getAll(Pageable pageable){
        return ResponseEntity.ok().body(sampleService.getAll(pageable).getContent());
    }

    @GetMapping("findcod")
    public ResponseEntity<List<Sample>> getByCod(@RequestParam("cod") String cod, Pageable pageable){
        return ResponseEntity.ok().body(sampleService.getByCod(cod, pageable));
    }

    @GetMapping("findfamily")
    public ResponseEntity<List<Sample>> getByFamily(@RequestParam("family") String family, Pageable pageable){
        return ResponseEntity.ok().body(sampleService.getByFamily(family, pageable));
    }

    @GetMapping("findsciname")
    public ResponseEntity<List<Sample>> getBySciName(@RequestParam("sciname") String sciName, Pageable pageable){
        return ResponseEntity.ok().body(sampleService.getBySciName(sciName, pageable));
    }

    @GetMapping("findcomname")
    public ResponseEntity<List<Sample>> getByComName(@RequestParam("comname") String comName, Pageable pageable){
        return ResponseEntity.ok().body(sampleService.getByComName(comName, pageable));
    }

    @PostMapping("insert")
    public ResponseEntity<Sample> insert(@RequestBody @Valid SampleDTO sampleDTO){
        Sample sample = sampleService.convertToEntity(sampleDTO);
        Sample newSample = sampleService.insert(sample);
        return ResponseEntity.created(null).body(newSample);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Sample> update(@RequestBody SampleDTO newSample, @PathVariable String id){
        Optional<Sample> sample = sampleService.findById(id);
        Sample attSample = sampleService.convertToEntity(newSample);
        if(sample.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        sampleService.update(id, attSample);
        return ResponseEntity.ok().body(attSample);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<Sample> delete(@PathVariable String id){
        Optional<Sample> sample = sampleService.findById(id);
        if(sample.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        sampleService.delete(id);
        return ResponseEntity.ok().body(null);
    }
}
