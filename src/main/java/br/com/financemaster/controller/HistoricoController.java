package br.com.financemaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
