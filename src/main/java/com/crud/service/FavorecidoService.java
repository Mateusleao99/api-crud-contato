package com.crud.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.domain.Conta;
import com.crud.domain.Favorecido;
import com.crud.dto.FavorecidoDTO;
import com.crud.repository.FavorecidoRepository;

@Service
public class FavorecidoService {
	
	@Autowired
	public FavorecidoRepository rep;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<FavorecidoDTO> getFavorecido(){
		return rep.findAll()
				.stream()
				.map(FavorecidoDTO::create)
				.collect(Collectors.toList());
	}
	
	public Optional<FavorecidoDTO> getFavorecidoPorCPF(String cpf){
		return rep.findById(cpf)
				.stream()
				.map(FavorecidoDTO::create)
				.findFirst();
	}

	public String excluirFavorecido(String cpf) {
		rep.deleteById(cpf);
		return "Favorecido excluído!";
	}

	public FavorecidoDTO atualizarFavorecido(FavorecidoDTO favorecidoDTO) {
		Assert.notNull(favorecidoDTO.getCpf(),"Não foi possivel atualizar o registro");
		
		// Busca o carro no banco de dados
        Optional<Favorecido> favorecido = rep.findById(favorecidoDTO.getCpf());
        if(favorecido.isPresent()) {
            Favorecido db = favorecido.get();
            // Copiar as propriedades
            db.setNome(favorecidoDTO.getNome());
            db.setSobrenome(favorecidoDTO.getSobrenome());
            db.setDataNascimento(favorecidoDTO.getDataNascimento());

            // Atualiza o carro
            rep.save(db);

            return FavorecidoDTO.create(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
		
	}

	@Transactional
	public FavorecidoDTO criarFavorecido(FavorecidoDTO favorecidoDTO) {
		Favorecido favorecido = new Favorecido();
		favorecido.setCpf(favorecidoDTO.getCpf());
		favorecido.setNome(favorecidoDTO.getNome());
		favorecido.setSobrenome(favorecidoDTO.getSobrenome());
		favorecido.setDataNascimento(favorecidoDTO.getDataNascimento());
		favorecido.setContas(favorecidoDTO.getContas());
		
		Optional<Favorecido> optionalFavorecido = rep.findById(favorecidoDTO.getCpf());
		if(optionalFavorecido.isPresent()) {
			throw new RuntimeException("Favorecido já cadastrado!");
		}

		return FavorecidoDTO.create(rep.save(favorecido));
	}
	
	
	
}
