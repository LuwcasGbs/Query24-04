package com.query.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.entities.Aluno;
import com.query.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/aluno")

public class AlunoController {
    
    private final AlunoService alunoService;
    
    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
      
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getProductById(@PathVariable Long id) {
        Aluno aluno = alunoService.getAlunoById(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.getAllAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping("/")
    public ResponseEntity<Aluno> criarAluno(@RequestBody @Valid Aluno aluno) {
        Aluno criarAluno = alunoService.salvarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
        Aluno updatedAluno = alunoService.updateAluno(id, aluno);
        if (updatedAluno != null) {
            return ResponseEntity.ok(updatedAluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deleteAluno(@PathVariable Long id) {
        boolean deleted = alunoService.deleteAluno(id);
        if (deleted) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
  //Query Method Cidade
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade) {
    	List<Aluno> alunos = alunoService.buscarAlunosPorCidade(cidade);
    	return ResponseEntity.ok(alunos);
    }
    
    //Query Method Nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome) {
    	List<Aluno> alunos = alunoService.buscarAlunosPorNome(nome);
    	return ResponseEntity.ok(alunos);
    }
    
    //Query Methodo Por Email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorEmail(@PathVariable String email){
    	List<Aluno> alunos = alunoService.buscarAlunosPorEmail(email);
    	return ResponseEntity.ok(alunos);
    }
    
    //Query Methodo Por Renda
    @GetMapping("/renda/{renda}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorRenda(@PathVariable double renda){
    	List<Aluno> alunos = alunoService.buscarAlunosPorRenda(renda);
    	return ResponseEntity.ok(alunos);
    }
    
    //Query Methodo Por RA
    @GetMapping("/ra/{ra}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorRa(@PathVariable String ra) {
    	List<Aluno> alunos = alunoService.buscarAlunosPorRa(ra);
    	return ResponseEntity.ok(alunos);
    }
    //ESTRUTURA:
    //@GetMapping("/endereço da busca/{atributo a ser buscado -> (normalmente o mesmo endereço da busca)}")
    //public ResponseEntity(tratar respostas)<List<Entidade (Lista da Entidade)>> nome recebido(@PathVariable ->(captura o que o usuario digitar) Tipo do dado atributo que será buscado) {
    //Lista<Entidade> variável que retorna o valor = entityService.nome recebido(atributo);
    //return ResponseEntity.ok(variável que retorna o valor); -> Resposta personalizada
 }
