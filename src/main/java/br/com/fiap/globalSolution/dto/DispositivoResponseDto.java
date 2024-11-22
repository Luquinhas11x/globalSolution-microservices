package br.com.fiap.globalSolution.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Data
public class DispositivoResponseDto {
    private Long id;
    private String nome;
    private String tipo;
    private BigDecimal consumoAtual;
    private BigDecimal consumoDiario;
    private boolean status;
}
