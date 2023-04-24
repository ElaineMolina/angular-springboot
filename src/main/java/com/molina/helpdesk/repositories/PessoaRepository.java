package com.molina.helpdesk.repositories;

import com.molina.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
   Optional<Pessoa> findByCpf(String cpf);
   Optional<Pessoa> findByEmail(String email);
}
