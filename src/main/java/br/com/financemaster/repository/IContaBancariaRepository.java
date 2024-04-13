package br.com.financemaster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.financemaster.model.ContaBancaria;

@Repository
public interface IContaBancariaRepository extends CrudRepository<ContaBancaria, Long>{

}
