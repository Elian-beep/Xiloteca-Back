package br.com.elian.Xiloteca.controller;

import br.com.elian.Xiloteca.entity.Sample;
import br.com.elian.Xiloteca.entity.dto.SampleDTO;
import br.com.elian.Xiloteca.service.SampleService;
import com.mongodb.internal.authentication.SaslPrep;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Sample>> getAll(){
        return ResponseEntity.ok().body(sampleService.getAll());
    }

    @PostMapping("insert")
    public ResponseEntity<Sample> insert(@RequestBody @Valid SampleDTO sampleDTO){
        Sample sample = sampleService.convertToEntity(sampleDTO);
        Sample newSample = sampleService.insert(sample);
        return ResponseEntity.created(null).body(newSample);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<Sample> delete(@PathVariable String id){
        Optional<Sample> sample = sampleService.findById(id);
        if(sample.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        sampleService.remove(id);
        return ResponseEntity.ok().body(null);
    }
}
