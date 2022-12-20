package br.com.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{
	
	List<Pessoa> findAll(); //quando for chamado o findAll ele vai retornar uam lista de pessoas
	
	Pessoa findByCodigo (int codigo); 
	
	List<Pessoa> findByOrderByNome();
	
	List<Pessoa> findByNomeContaining(String termo);
	
	List<Pessoa> findByNomeStartsWith(String termo);
	
	List<Pessoa> findByNomeEndsWith(String termo);
	
	@Query(value = "SELECT SUM(idade) FROM pessoa", nativeQuery = true)
	int somaIdades();
	
	@Query(value = "SELECT * FROM pessoa WHERE idade >= :idade", nativeQuery = true)
	List<Pessoa> idadeMaiorIgual(int idade);
}









