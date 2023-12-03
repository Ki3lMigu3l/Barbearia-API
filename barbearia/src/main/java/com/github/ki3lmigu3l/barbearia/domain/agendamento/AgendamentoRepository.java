package com.github.ki3lmigu3l.barbearia.domain.agendamento;

import com.github.ki3lmigu3l.barbearia.domain.agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
