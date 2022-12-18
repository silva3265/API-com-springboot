package br.com.projeto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{
	

}
