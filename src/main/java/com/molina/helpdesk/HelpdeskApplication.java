package com.molina.helpdesk;

import com.molina.helpdesk.domain.Chamado;
import com.molina.helpdesk.domain.Cliente;
import com.molina.helpdesk.domain.Tecnico;
import com.molina.helpdesk.domain.enums.Perfil;
import com.molina.helpdesk.domain.enums.Prioridade;
import com.molina.helpdesk.domain.enums.Status;
import com.molina.helpdesk.repositories.ChamadoRepository;
import com.molina.helpdesk.repositories.ClienteRepository;
import com.molina.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Elaine Molina", "15753929842", "molina@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "19586383237","torvalds@mail.com","123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1,cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
