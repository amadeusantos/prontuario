package br.upe.prontuario.domain;

import br.upe.prontuario.domain.enums.SexoEnum;
import br.upe.prontuario.domain.enums.TipoSanguineoEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String nomeCompleto;

    private Date dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private TipoSanguineoEnum tipoSanguineo;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;

    private String telefone;

    public String getCpf() {
        return cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public TipoSanguineoEnum getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSaguineo(TipoSanguineoEnum tipoSaguineo) {
        this.tipoSanguineo = tipoSaguineo;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
