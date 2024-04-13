package br.com.financemaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.financemaster.model.Cartao;
import br.com.financemaster.repository.CartaoRepository;

@Controller("CartaoController")
@RequestMapping(value = "/cartao")
public class CartaoController {
    
    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping(value="/", produces="application/json")
    public ResponseEntity<List<Cartao>> getAll (){
        List<Cartao> cartao = (List<Cartao>) this.cartaoRepository.findAll();

        return new ResponseEntity<>(cartao, HttpStatus.OK);
    }

    @PostMapping(value="/", produces="application/json")
    public ResponseEntity<Cartao> create (@RequestBody Cartao cartao){
        Cartao cartaoSalvo = cartaoRepository.save(cartao);

        return new ResponseEntity<>(cartaoSalvo, HttpStatus.OK);
    }
}
