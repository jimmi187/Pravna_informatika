package com.pravnainfo.pravnainformatika.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer kazna;
    private Boolean hladnoOruzje;
}
