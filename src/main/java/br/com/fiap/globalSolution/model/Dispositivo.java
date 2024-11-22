package br.com.fiap.globalSolution.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "dispositivos")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 60)
    private String nome;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "consumo_atual", precision = 16, scale = 2)
    private BigDecimal consumoAtual;

    @Column(name = "consumo_diario", precision = 16, scale = 2)
    private BigDecimal consumoDiario;

    @Column(name = "status", nullable = false)
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getConsumoAtual() {
        return consumoAtual;
    }

    public void setConsumoAtual(BigDecimal consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public BigDecimal getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(BigDecimal consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
