package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.domain.Favorecido;

@Repository
public interface FavorecidoRepository extends JpaRepository<Favorecido, String> {

}
