package br.upe.prontuario.domain.dto;

import br.upe.prontuario.domain.enums.SexoEnum;
import br.upe.prontuario.domain.enums.TipoSanguineoEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public class PacienteDTO {

    @CPF(message = "CPF inválido!")
    private String cpf;

    @Size(min = 4, max = 255, message = "Tamanho inválido!")
    private String nomeCompleto;

    private Date dataDeNascimento;

    @NotNull(message = "É nescesario um tipo sanguinio!")
    private TipoSanguineoEnum tipoSanguineo;

    @NotNull(message = "É nescesario um sexo!")
    private SexoEnum sexo;

    private String telefone;

    public String getCpf() {
        return cpf;
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

    public void setTipoSanguineo(TipoSanguineoEnum tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
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
