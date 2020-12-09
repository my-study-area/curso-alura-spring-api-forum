package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	@NotEmpty @NotNull @Length(min = 5)
	private String titulo;
	
	@NotEmpty @NotNull @Length(min = 10)
	private String mensagem;
	
	public AtualizacaoTopicoForm() {
	}

	public AtualizacaoTopicoForm(Topico topico) {
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualiza(TopicoRepository topicoRepository, Long id) {
		Topico topico = topicoRepository.findById(id).orElse(null);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}
	
}
