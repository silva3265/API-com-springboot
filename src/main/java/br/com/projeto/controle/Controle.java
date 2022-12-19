package br.com.projeto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.modelo.Pessoa;
import br.com.projeto.repositorio.Repositorio;

@RestController
public class Controle {

	@Autowired
	private Repositorio acao;

	@PostMapping("/api")
	public Pessoa cadastrar(@RequestBody Pessoa obj) {
		return acao.save(obj);
	}

	@GetMapping("/api")
	public List<Pessoa> selecionar() {
		return acao.findAll();
	}

	@GetMapping("/api/{codigo}")
	public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
		return acao.findByCodigo(codigo);
	}

	@PutMapping("/api")
	public Pessoa editar(@RequestBody Pessoa obj) { //No put a gente tem que passar o Objeto completo
		return acao.save(obj);
	}
	
	@DeleteMapping("/api/{codigo}")
	public void remover(@PathVariable int codigo) {
		Pessoa obj = selecionarPeloCodigo(codigo);
		
		acao.delete(obj);
	}
	
	@GetMapping("/api/contador")
	public long contador() {
		return acao.count();
	}

	@GetMapping("")
	public String mensagem() {
		return "Hello Word";
	}

	@GetMapping("/boasVindas")
	public String boasVindas() {
		return "Seja bem vindos(a)";
	}

	@GetMapping("/boasVindas/{nome}")
	public String boasVindas(@PathVariable String nome) {
		return "Seja bem vindos(a)" + nome;
	}

	@PostMapping("/pessoa")
	public Pessoa pessoa(@RequestBody Pessoa p) {
		return p;
	}

}
