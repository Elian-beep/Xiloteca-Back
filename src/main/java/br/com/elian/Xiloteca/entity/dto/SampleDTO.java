package br.com.elian.Xiloteca.entity.dto;

import br.com.elian.Xiloteca.entity.Picture;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SampleDTO {
    @NotNull
    public String cod;

    public String blade;
    public String herb;
    public String family;
    public String sciName;
    public String comName;
    public String collector;

    public Date collDate;

    public String determiner;
    public String sender;
    public String desc;
    public String obs;
    public List<Picture> pictures = new ArrayList<>();

    public SampleDTO(String cod, String blade, String herb, String family, String sciName, String comName, String collector, Date collDate, String determiner, String sender, String desc, String obs, List<Picture> pictures) {
        this.cod = cod;
        this.blade = blade;
        this.herb = herb;
        this.family = family;
        this.sciName = sciName;
        this.comName = comName;
        this.collector = collector;
        this.collDate = collDate;
        this.determiner = determiner;
        this.sender = sender;
        this.desc = desc;
        this.obs = obs;
        this.pictures = pictures;
    }
}
