package br.com.financemaster.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financemaster.model.Usuario;
import br.com.financemaster.model.DTO.AuthenticationDTO;
import br.com.financemaster.model.DTO.LoginResponseDTO;
import br.com.financemaster.repository.IUsuarioRepository;
import br.com.financemaster.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data)
    {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        System.out.println(usernamePassword);

        try
        {
            var auth  = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((Usuario)auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e);
            return ResponseEntity.internalServerError().build();
        }
    }

    // @PostMapping("/register")
    // public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
    //     return new ResponseEntity();
    // }

}