package com.crud.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.domain.Favorecido;
import com.crud.dto.FavorecidoDTO;
import com.crud.service.FavorecidoService;

@RestController
@RequestMapping("/api/v1/favorecido")
public class FavorecidoController {
	
	@Autowired
	private FavorecidoService service;
	
	@PostMapping
    public FavorecidoDTO criarFavorecido(@RequestBody FavorecidoDTO favorecidoDTO) {
    	return service.criarFavorecido(favorecidoDTO);
    }

    @GetMapping()
    public Iterable<FavorecidoDTO> getFavorecido() {
        return service.getFavorecido();
    }
    
    @GetMapping("{cpf}")
    public Optional<FavorecidoDTO> getCpf(@PathVariable("cpf") String cpf){
    	return service.getFavorecidoPorCPF(cpf);
    }
    
    @DeleteMapping("{cpf}")
    public String excluirFavorecido(@PathVariable("cpf") String cpf) {
    	return service.excluirFavorecido(cpf);
    }
    
    @PutMapping
    public Favorecido atualizarFavorecido(@RequestBody FavorecidoDTO favorecido) {
    	return service.atualizarFavorecido(favorecido);
    }

}
