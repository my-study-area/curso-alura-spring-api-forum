package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;

public class DetalhesDoTopicoDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private String nomeAutor;
	private List<RespostaDto> respostas = new ArrayList<>();
	
	public DetalhesDoTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.status = topico.getStatus();
		this.nomeAutor = topico.getAutor().getNome();
		this.respostas = topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList() );
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}
	
}
