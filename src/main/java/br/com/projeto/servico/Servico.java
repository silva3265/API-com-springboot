package br.com.projeto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.modelo.Mensagem;

@Service
public class Servico {
	
	@Autowired
	private Mensagem mensagem;

}
