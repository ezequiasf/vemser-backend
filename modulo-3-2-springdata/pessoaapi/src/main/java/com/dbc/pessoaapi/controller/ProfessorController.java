package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    @PostMapping
    public ProfessorEntity salvar (@RequestBody ProfessorEntity pe){
        return professorRepository.save(pe);
    }

    @GetMapping
    public List<ProfessorEntity> listar (){
        return professorRepository.findAll();
    }
}
