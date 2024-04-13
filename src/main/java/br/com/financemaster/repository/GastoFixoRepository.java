package br.com.financemaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.financemaster.model.GastoFixo;

@Repository
public interface GastoFixoRepository extends CrudRepository<GastoFixo, Long>{

}
