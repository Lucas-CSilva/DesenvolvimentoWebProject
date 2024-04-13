package br.com.financemaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.financemaster.model.RendaFixa;

@Repository
public interface IRendaFixaRepository extends CrudRepository<RendaFixa, Long>{

}
