package br.com.elian.Xiloteca.service;

import br.com.elian.Xiloteca.entity.Picture;
import br.com.elian.Xiloteca.entity.Sample;
import br.com.elian.Xiloteca.entity.dto.PictureDTO;
import br.com.elian.Xiloteca.entity.dto.SampleDTO;
import br.com.elian.Xiloteca.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SampleService {
    @Autowired
    SampleRepository sampleRepository;

    public List<Sample> getAll(){
        return sampleRepository.findAll();
    }

    public Sample insert(@RequestBody Sample sample){
        sampleRepository.insert(sample);
        return sample;
    }

    public Sample update(String id, Sample newSample){
        Optional<Sample> sample = findById(id);
        if(sample.isPresent()){
            Sample attSample = sample.get();
            attSample.setCod(newSample.getCod() != null ? newSample.getCod() : attSample.getCod());
            attSample.setBlade(newSample.getBlade() != null ? newSample.getBlade() : attSample.getBlade());
            attSample.setHerb(newSample.getHerb() != null ? newSample.getHerb() : attSample.getHerb());
            attSample.setFamily(newSample.getFamily() != null ? newSample.getFamily() : attSample.getFamily());
            attSample.setSciName(newSample.getSciName() != null ? newSample.getSciName() : attSample.getSciName());
            attSample.setComName(newSample.getComName() != null ? newSample.getComName() : attSample.getComName());
            attSample.setCollector(newSample.getCollector() != null ? newSample.getCollector() : attSample.getCollector());
            attSample.setCollDate(newSample.getCollDate() != null ? newSample.getCollDate() : attSample.getCollDate());
            attSample.setDeterminer(newSample.getDeterminer() != null ? newSample.getDeterminer() : attSample.getDeterminer());
            attSample.setSender(newSample.getSender() != null ? newSample.getSender() : attSample.getSender());
            attSample.setDesc(newSample.getDesc() != null ? newSample.getDesc() : attSample.getDesc());
            attSample.setObs(newSample.getObs() != null ? newSample.getObs() : attSample.getObs());
            sampleRepository.save(sample.get());
            return sample.get();
        }
        return null;
    }

    public void delete(String id){
        Optional<Sample> sample = findById(id);
        sample.ifPresent(value -> sampleRepository.delete(value));
    }

    public Optional<Sample> findById(String id){
        return sampleRepository.findById(id);
    }

    public Sample convertToEntity(SampleDTO sampleDTO){
        Sample sample = new Sample();
        sample.setCod(sampleDTO.getCod());
        sample.setBlade(sampleDTO.getBlade());
        sample.setHerb(sampleDTO.getHerb());
        sample.setFamily(sampleDTO.getFamily());
        sample.setSciName(sampleDTO.getSciName());
        sample.setComName(sampleDTO.getComName());
        sample.setCollector(sampleDTO.getCollector());
        sample.setCollDate(sampleDTO.getCollDate());
        sample.setDeterminer(sampleDTO.getDeterminer());
        sample.setSender(sampleDTO.getSender());
        sample.setDesc(sampleDTO.getDesc());
        sample.setObs(sampleDTO.getObs());

        List<Picture> pictures = new ArrayList<>();
        for(Picture pictureOfList: sampleDTO.getPictures()){
            Picture picture = new Picture();
            picture.setId(UUID.randomUUID().toString());
            picture.setTitle(pictureOfList.getTitle());
            picture.setLink(pictureOfList.getLink());
            pictures.add(picture);
        }
        sample.setPictures(pictures);

        return sample;
    }
}
