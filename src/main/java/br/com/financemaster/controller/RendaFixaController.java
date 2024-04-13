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

import br.com.financemaster.model.RendaFixa;
import br.com.financemaster.repository.IRendaFixaRepository;

@Controller("RendaFixaController")
@RequestMapping(value = "/rendaFixa")
public class RendaFixaController {

    @Autowired
    private IRendaFixaRepository rendaFixaRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<RendaFixa>> getAll()
    {
        try 
        {
            List<RendaFixa> contaBancaria = (List<RendaFixa>) this.rendaFixaRepository.findAll();
            return new ResponseEntity<>(contaBancaria, HttpStatus.OK);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<RendaFixa> getById(@PathVariable("id") Long id) {

        try
        {
            Optional<RendaFixa> rendaFixa_get = rendaFixaRepository.findById(id);
            return new ResponseEntity<RendaFixa>(rendaFixa_get.get(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/insert", produces="application/json")
    public ResponseEntity<RendaFixa> insert (@RequestBody RendaFixa rendaFixa)
    {  
        try
        {
            RendaFixa rendaFixaSalva = rendaFixaRepository.save(rendaFixa);
            return new ResponseEntity<>(rendaFixaSalva, HttpStatus.OK);
        }
        catch(Exception ex)
        {
            System.out.println("Error at insert new conta bancaria: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/update", produces="application/json")
    public ResponseEntity<RendaFixa> update(@RequestBody RendaFixa rendaFixa)
    {
        try
        {
            RendaFixa newRendaFixa = rendaFixaRepository.save(rendaFixa);
            return new ResponseEntity<RendaFixa>(newRendaFixa, HttpStatus.OK);
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
            rendaFixaRepository.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
