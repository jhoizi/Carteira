package com.mercado.carteira.repositories;

import com.mercado.carteira.models.ListaAcompanhamentoModel;
import com.mercado.carteira.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends CrudRepository<ListaAcompanhamentoModel, Integer> {
    List<ListaAcompanhamentoModel> findByUsuario(UsuarioModel usuario);

    ListaAcompanhamentoModel findByCodigo(int codigo);

}
