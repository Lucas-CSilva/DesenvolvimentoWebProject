package br.com.financemaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.financemaster.model.GastoVariavel;

@Repository
public interface GastoVariavelRepository extends CrudRepository<GastoVariavel, Long>{

}
