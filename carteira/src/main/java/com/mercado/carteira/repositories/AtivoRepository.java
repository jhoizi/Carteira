package com.mercado.carteira.repositories;


import com.mercado.carteira.models.AtivoModel;
import com.mercado.carteira.models.ListaAcompanhamentoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtivoRepository extends CrudRepository<AtivoModel, Integer> {
    List<AtivoModel> findByLista(ListaAcompanhamentoModel lista);

    AtivoModel findByCodigo(int codigo);
}
