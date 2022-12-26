package br.com.projeto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.modelo.Mensagem;
import br.com.projeto.modelo.Pessoa;
import br.com.projeto.repositorio.Repositorio;

@Service
public class Servico {
	
	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private Repositorio acao;
	
	public ResponseEntity<?> cadastrar(Pessoa obj){
		
		if (obj.getNome().equals("")) {
			mensagem.setMensagem("o nome precisa ser preenchido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		}else if (obj.getIdade() < 0) {
			mensagem.setMensagem("Informe uma idade valida");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST); 
		}else {
			return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
		}
	}

}
