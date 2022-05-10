package com.mercado.carteira.repositories;


import com.mercado.carteira.models.CarteiraModel;
import com.mercado.carteira.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteiraRepository extends CrudRepository<CarteiraModel, Integer> {
    List<CarteiraModel> findByUsuario(UsuarioModel usuario);
    CarteiraModel findByCodigo(int codigo);
}
