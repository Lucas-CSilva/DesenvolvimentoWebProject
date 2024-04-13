package br.com.financemaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.financemaster.model.ContaBancaria;
import br.com.financemaster.repository.IContaBancariaRepository;

@Controller("ContaBancariaController")
@RequestMapping(value = "/contaBancaria")
public class ContaBancariaController {

    @Autowired
    private IContaBancariaRepository contaBancariaRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<ContaBancaria>> getAll()
    {
        try 
        {
            List<ContaBancaria> contaBancaria = (List<ContaBancaria>) this.contaBancariaRepository.findAll();
            return new ResponseEntity<>(contaBancaria, HttpStatus.OK);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<ContaBancaria> getById(@PathVariable("id") Long id) {

        try
        {
            Optional<ContaBancaria> contaBancaria_get = contaBancariaRepository.findById(id);
            return new ResponseEntity<ContaBancaria>(contaBancaria_get.get(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }   

    @PostMapping(value="/insert", produces="application/json")
    public ResponseEntity<ContaBancaria> insert (@RequestBody ContaBancaria contaBancaria)
    {  
        try
        {
            ContaBancaria contaBancariaSalva = contaBancariaRepository.save(contaBancaria);
            return new ResponseEntity<>(contaBancariaSalva, HttpStatus.OK);
        }
        catch(Exception ex)
        {
            System.out.println("Error at insert new conta bancaria: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/update", produces="application/json")
    public ResponseEntity<ContaBancaria> update(@RequestBody ContaBancaria contaBancaria)
    {
        try
        {
            ContaBancaria newContaBancaria = contaBancariaRepository.save(contaBancaria);
            return new ResponseEntity<ContaBancaria>(newContaBancaria, HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("Error at update new contaBancaria: "+e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable("id") Long id)
    {
        try
        {
            contaBancariaRepository.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
