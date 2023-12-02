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

    public void remove(String id){
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
        for(PictureDTO pictureOfList: sampleDTO.getPictures()){
            Picture picture = new Picture();
            picture.setId(UUID.randomUUID().toString());
            picture.setTitle(pictureOfList.title());
            picture.setLink(pictureOfList.link());
            pictures.add(picture);
        }
        sample.setPictures(pictures);

        return sample;
    }
}
