package com.mercado.carteira.repositories;


import com.mercado.carteira.models.CarteiraModel;
import com.mercado.carteira.models.OperacaoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacaoRepository extends CrudRepository<OperacaoModel, Integer> {
    OperacaoModel findByCodigo(int codigo);

    List<OperacaoModel> findByCarteira(CarteiraModel carteira);
}
