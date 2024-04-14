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

import br.com.financemaster.model.Historico;
import br.com.financemaster.repository.IHistoricoRepository;

@Controller("HistoricoController")
@RequestMapping(value = "/historico")
public class HistoricoController {
    @Autowired
    private IHistoricoRepository historicoRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Historico>> getAll()
    {
        try 
        {
            List<Historico> contaBancaria = (List<Historico>) this.historicoRepository.findAll();
            return new ResponseEntity<>(contaBancaria, HttpStatus.OK);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<Historico> getById(@PathVariable("id") Long id) 
    {
        try
        {
            Optional<Historico> historico_get = historicoRepository.findById(id);
            return new ResponseEntity<Historico>(historico_get.get(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
    
    @PostMapping(value="/insert", produces="application/json")
    public ResponseEntity<Historico> insert (@RequestBody Historico historico)
    {  
        try
        {
            Historico newHistorico = historicoRepository.save(historico);
            return new ResponseEntity<>(newHistorico, HttpStatus.OK);
        }
        catch(Exception ex)
        {
            System.out.println("Error at insert new historico: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/update", produces="application/json")
    public ResponseEntity<Historico> update(@RequestBody Historico historico)
    {
        try
        {
            Historico newHistorico = historicoRepository.save(historico);
            return new ResponseEntity<Historico>(newHistorico, HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("Error at update new historico: "+e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable("id") Long id)
    {
        try
        {
            historicoRepository.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
