package br.com.elian.Xiloteca.controller;

import br.com.elian.Xiloteca.entity.Handler;
import br.com.elian.Xiloteca.entity.dto.AuthenticationDTO;
import br.com.elian.Xiloteca.entity.dto.LoginResponseDTO;
import br.com.elian.Xiloteca.entity.dto.RegisterDTO;
import br.com.elian.Xiloteca.infra.security.TokenService;
import br.com.elian.Xiloteca.repository.HandlerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private HandlerRepository handlerRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.user(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.generateToken((Handler) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if(this.handlerRepository.findByUser(registerDTO.user()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        Handler handler = new Handler(registerDTO.name(), registerDTO.user(), encryptedPassword, registerDTO.role());

        this.handlerRepository.save(handler);
        return ResponseEntity.ok().build();
    }

}
