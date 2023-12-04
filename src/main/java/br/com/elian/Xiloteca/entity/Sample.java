package br.com.elian.Xiloteca.entity;

import br.com.elian.Xiloteca.entity.dto.SampleDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sample")
public class Sample {
    @Id
    private String id;

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
    private List<Picture> pictures = new ArrayList<>();

}
