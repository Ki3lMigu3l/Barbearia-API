package com.github.ki3lmigu3l.barbearia.domain.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByClienteIdAndData(Long idCliente, LocalDateTime data);

    boolean existsByClienteIdAndDataBetween(Long aLong, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
