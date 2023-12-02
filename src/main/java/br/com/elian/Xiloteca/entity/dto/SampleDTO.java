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
    private String cod;

    private String blade;
    private String herb;
    private String family;
    private String sciName;
    private String comName;
    private String collector;

    private Date collDate;

    private String determiner;
    private String sender;
    private String desc;
    private String obs;
    private List<PictureDTO> pictures = new ArrayList<>();

    public SampleDTO(String cod, String blade, String herb, String family, String sciName, String comName, String collector, Date collDate, String determiner, String sender, String desc, String obs, List<PictureDTO> pictures) {
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
