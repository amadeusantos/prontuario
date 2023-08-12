package br.upe.prontuario.service;

import br.upe.prontuario.domain.Paciente;
import br.upe.prontuario.domain.dto.PacienteDTO;
import br.upe.prontuario.repository.PacienteRepository;
import br.upe.prontuario.utils.ProntuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPaciente(Long id) throws ProntuarioException {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isEmpty()) {
            throw new ProntuarioException("Paciente não encontrado!");
        }

        return paciente.get();
    }

    public Paciente adicionarPaciente(PacienteDTO pacienteDTO) throws ProntuarioException {

        if (pacienteRepository.existsByCpf(pacienteDTO.getCpf())) {
            throw new ProntuarioException("Já existe um paciente com esse CPF!");
        }

        Paciente paciente = new Paciente();
        paciente.setNomeCompleto(pacienteDTO.getNomeCompleto());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataDeNascimento(pacienteDTO.getDataDeNascimento());
        paciente.setTipoSaguineo(pacienteDTO.getTipoSanguineo());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setTelefone(pacienteDTO.getTelefone());


        return pacienteRepository.save(paciente);
    }

    public Paciente alterarPaciente(Long id, PacienteDTO pacienteDTO) throws ProntuarioException {
        Paciente pacienteSalvar = buscarPaciente(id);
        pacienteSalvar.setNomeCompleto(pacienteDTO.getNomeCompleto());
        if (!pacienteDTO.getCpf().equals(pacienteSalvar.getCpf())) {
            pacienteSalvar.setCpf(pacienteDTO.getCpf());
        }
        pacienteSalvar.setDataDeNascimento(pacienteDTO.getDataDeNascimento());
        pacienteSalvar.setTipoSaguineo(pacienteDTO.getTipoSanguineo());
        pacienteSalvar.setSexo(pacienteDTO.getSexo());
        pacienteSalvar.setTelefone(pacienteDTO.getTelefone());

        return pacienteRepository.save(pacienteSalvar);
    }

    public void excluirPaciente(Long id) throws ProntuarioException {
        if (!pacienteRepository.existsById(id)) {
            throw new ProntuarioException("Paciente não encontrado!");
        }

        pacienteRepository.deleteById(id);
    }

}
