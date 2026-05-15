package com.fabricasoftware.app_demo.service;

import com.fabricasoftware.app_demo.model.Desenvolvedor;
import com.fabricasoftware.app_demo.model.EstadoTicket;
import com.fabricasoftware.app_demo.model.Pessoa;
import com.fabricasoftware.app_demo.model.Ticket;
import com.fabricasoftware.app_demo.repository.DesenvolvedorRepository;
import com.fabricasoftware.app_demo.repository.PessoaRepository;
import com.fabricasoftware.app_demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final PessoaRepository pessoaRepository;
    private final DesenvolvedorRepository desenvolvedorRepository;

    public TicketService(TicketRepository ticketRepository,
                         PessoaRepository pessoaRepository,
                         DesenvolvedorRepository desenvolvedorRepository) {
        this.ticketRepository = ticketRepository;
        this.pessoaRepository = pessoaRepository;
        this.desenvolvedorRepository = desenvolvedorRepository;
    }

    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }

    public Ticket buscarPorId(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado com id: " + id));
    }

    public Ticket cadastrar(String titulo, String descricao, Long prioridade, Long criadorId, Long responsavelId) {
        Pessoa criador = null;
        if (criadorId != null) {
            criador = pessoaRepository.findById(criadorId)
                    .orElseThrow(() -> new RuntimeException("Criador não encontrado com id: " + criadorId));
        }

        Desenvolvedor responsavel = null;
        if (responsavelId != null) {
            responsavel = desenvolvedorRepository.findById(responsavelId)
                    .orElseThrow(() -> new RuntimeException("Responsável não encontrado com id: " + responsavelId));
        }

        Ticket ticket = new Ticket(null, titulo, descricao,
                prioridade != null ? prioridade : 1L,
                EstadoTicket.ABERTO, responsavel, criador);
        return ticketRepository.save(ticket);
    }

    public Ticket atualizar(Long id, String titulo, String descricao, Long prioridade, String estadoStr, Long criadorId, Long responsavelId) {
        Ticket ticket = buscarPorId(id);
        ticket.setTitulo(titulo);
        ticket.setDescricao(descricao);
        ticket.setPrioridade(prioridade != null ? prioridade : ticket.getPrioridade());

        if (estadoStr != null) {
            ticket.setEstado(EstadoTicket.valueOf(estadoStr));
        }

        if (criadorId != null) {
            Pessoa criador = pessoaRepository.findById(criadorId)
                    .orElseThrow(() -> new RuntimeException("Criador não encontrado com id: " + criadorId));
            ticket.setCriador(criador);
        }

        if (responsavelId != null) {
            Desenvolvedor dev = desenvolvedorRepository.findById(responsavelId)
                    .orElseThrow(() -> new RuntimeException("Responsável não encontrado com id: " + responsavelId));
            ticket.setResponsavel(dev);
            if (ticket.getEstado() == EstadoTicket.ABERTO) {
                ticket.setEstado(EstadoTicket.EM_ANDAMENTO);
            }
        } else {
            ticket.setResponsavel(null);
        }

        return ticketRepository.save(ticket);
    }

    public void excluir(Long id) {
        Ticket ticket = buscarPorId(id);
        ticketRepository.delete(ticket);
    }
}