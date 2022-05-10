package com.mercado.carteira.repositories;

import com.mercado.carteira.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    UsuarioModel findByIdentificador(int identificador);
}
