package com.query.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	//Query Methodo - Find By Cidade
	List<Aluno> findByCidade(String cidade);
	
	//Query Methodo - Find By Nome
	List<Aluno> findByNome(String nome);
	
	//Query Methodo - Find By Email 
	List<Aluno> findByEmail(String email); 
	
	//ESTRTUTURA:
	//Lista<Nome da Entidade> "findBy"Atributo"" (Tipo de dados nome do atributo);
	
	List<Aluno> findByRenda(double renda);
	
	List<Aluno> findByRa(String ra);
}