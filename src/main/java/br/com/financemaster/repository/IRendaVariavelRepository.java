package br.com.financemaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.financemaster.model.RendaVariavel;

@Repository
public interface IRendaVariavelRepository extends CrudRepository<RendaVariavel, Long>{

}
