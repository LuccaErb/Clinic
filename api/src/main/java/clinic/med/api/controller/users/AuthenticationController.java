package clinic.med.api.controller.users;

import clinic.med.api.config.security.DataTokenJWT;
import clinic.med.api.config.security.TokenService;
import clinic.med.api.domain.dto.users.DataAuthentication;
import clinic.med.api.domain.model.users.User;
import clinic.med.api.service.users.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationManager manager;
    private final AuthenticationServiceImpl service;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationServiceImpl service, AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.service = service;
        this.tokenService = tokenService;
    }




    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuthentication dataAuthentication) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(dataAuthentication.login(), dataAuthentication.password());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }
}
