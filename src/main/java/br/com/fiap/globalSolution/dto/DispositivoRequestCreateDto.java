package br.com.fiap.globalSolution.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DispositivoRequestCreateDto {
    private String nome;
    private String tipo;
    private BigDecimal consumoAtual;
    private BigDecimal consumoDiario;
    private boolean status;
}
