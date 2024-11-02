package com.fmunoz.mutantesAPI.dtos;

import com.fmunoz.mutantesAPI.validations.ValidDna;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MutantePruebaDto {
    @ValidDna
    private String[] dna;
}
