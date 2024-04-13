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

import br.com.financemaster.model.GastoFixo;
import br.com.financemaster.repository.GastoFixoRepository;

@Controller("GastoFixoController")
@RequestMapping(value = "/gastoFixo")

public class GastoFixoController{
    
    @Autowired
    private GastoFixoRepository gastoFixoRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<GastoFixo>> getAll()
    {
        try 
        {
            List<GastoFixo> contaBancaria = (List<GastoFixo>) this.gastoFixoRepository.findAll();
            return new ResponseEntity<>(contaBancaria, HttpStatus.OK);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/{id}", produces="application/json")
    public ResponseEntity<GastoFixo> getById(@PathVariable("id") Long id) {

        try
        {
            Optional<GastoFixo> gastoFixo_get = gastoFixoRepository.findById(id);
            return new ResponseEntity<GastoFixo>(gastoFixo_get.get(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/insert", produces="application/json")
    public ResponseEntity<GastoFixo> insert (@RequestBody GastoFixo gastoFixo)
    {  
        try
        {
            GastoFixo gastoFixoSalvo = gastoFixoRepository.save(gastoFixo);
            return new ResponseEntity<>(gastoFixoSalvo, HttpStatus.OK);
        }
        catch(Exception ex)
        {
            System.out.println("Error at insert new gastoFixo: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/update", produces="application/json")
    public ResponseEntity<GastoFixo> update(@RequestBody GastoFixo gastoFixo)
    {
        try
        {
            GastoFixo newGastoFixo = gastoFixoRepository.save(gastoFixo);
            return new ResponseEntity<GastoFixo>(newGastoFixo, HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("Error at update new gastoFixo: "+e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable("id") Long id)
    {
        try
        {
            gastoFixoRepository.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}