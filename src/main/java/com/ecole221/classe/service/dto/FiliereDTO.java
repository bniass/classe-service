package com.ecole221.classe.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDTO {

    private long idDTO;
    private String libelleDTO;

}
