package com.pravnainfo.pravnainformatika.model;

import com.pravnainfo.pravnainformatika.model.enums.TipKazne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Presuda {
    @Id
    private Integer id;
    private String sudija;
    private String Osudjeni;
    private Integer brojZakona;
    @Nullable
    private Integer brojGodinaSluzenjaKazne;
    private Boolean isHladnoOruzje;
    private TipKazne tipKazne;
    private String opisKazne; // mozemo koristiti i List<MoguceKazne> ili da ubacujemo u 1 string (trenutno).
}
