package com.ecole221.classe.service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDTO {

    private long idDTO;
    @NotBlank(message = "Code classe obligatoire!")
    private String libelleDTO;

    @NotNull(message = "Montant inscription obliatoire!")
    @Min(value = 1, message = "Les frais d'inscription doivent être positifs")
    private int fraisInscriptionDTO;
    @NotNull(message = "Mensualité obliatoire!")
    @Min(value = 1, message = "La mensualité doit être positif")
    private int mensualiteDTO;
    @NotNull(message = "Autres frais obliatoire!")
    @Min(value = 1, message = "Les autres frais doivent être positifs")
    private int autreFraisDTO;

    private FiliereDTO filiereDTO;
}
