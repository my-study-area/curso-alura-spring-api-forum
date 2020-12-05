package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.TopicoRepository;
import br.com.alura.forum.controller.dto.TopicoDto;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@GetMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			return TopicoDto.converter(this.topicoRepository.findAll());
		}
		return TopicoDto.converter(this.topicoRepository.findByCursoNome(nomeCurso));
	}
}
