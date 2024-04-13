package br.com.financemaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.financemaster.model.Historico;

@Repository
public interface IHistoricoRepository extends CrudRepository<Historico, Long>{

}
