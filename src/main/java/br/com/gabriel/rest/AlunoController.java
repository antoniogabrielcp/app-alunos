package br.com.gabriel.rest;

import br.com.gabriel.model.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import br.com.gabriel.model.repository.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoRepository repository;

    @Autowired
    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Aluno> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody @Valid Aluno aluno){
        return repository.save(aluno);
    }

    @GetMapping("{id}")
    public Aluno acharPorId(@PathVariable Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(aluno -> {
                    repository.delete(aluno);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Aluno alunoAtualizado){
        repository
                .findById(id)
                .map(aluno -> {
                    alunoAtualizado.setId(aluno.getId());
                    return repository.save(alunoAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }
}
