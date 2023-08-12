package br.upe.prontuario.repository;

import br.upe.prontuario.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    public boolean existsByCpf(String cpf);

}
