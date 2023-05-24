package com.molina.helpdesk.services;

import com.molina.helpdesk.domain.Chamado;
import com.molina.helpdesk.domain.Cliente;
import com.molina.helpdesk.domain.Tecnico;
import com.molina.helpdesk.domain.enums.Perfil;
import com.molina.helpdesk.domain.enums.Prioridade;
import com.molina.helpdesk.domain.enums.Status;
import com.molina.helpdesk.repositories.ChamadoRepository;
import com.molina.helpdesk.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null, "Máscara Smith", "550.482.150-95", "mascara@mail.com", encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Sheegwa Smith ", "903.347.070-56", "sheegwa@mail.com", encoder.encode("123"));
        Tecnico tec3 = new Tecnico(null, "Sagwa  Smith", "271.068.470-54", "sagwa@mail.com", encoder.encode("123"));
        Tecnico tec4 = new Tecnico(null, "Lea Smith", "162.720.120-39", "lea@mail.com", encoder.encode("123"));
        Tecnico tec5 = new Tecnico(null, "Darth Smith", "778.556.170-27", "darth@mail.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "She-ra Smith", "111.661.890-74", "shera@mail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Boo Smith", "322.429.140-06", "boo@mail.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Ben Smith", "792.043.830-62", "ben@mail.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Gon Smith", "177.409.680-30", "gon@mail.com", encoder.encode("123"));
        Cliente cli5 = new Cliente(null, "Tongwa Smith", "081.399.300-83", "tongwa@mail.com", encoder.encode("123"));

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
    }
}
