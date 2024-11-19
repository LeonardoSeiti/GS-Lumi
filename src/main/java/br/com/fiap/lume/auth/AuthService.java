package br.com.fiap.lume.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.fiap.lume.Cliente.ClienteRepository;

@Service
public class AuthService {
    private final ClienteRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(ClienteRepository repository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public Token login(Credentials credentials) {
        var cliente = repository.findByEmail(credentials.email())
                .orElseThrow(() -> new RuntimeException("Acesso negado"));
        if (!passwordEncoder.matches(credentials.senha(), cliente.getSenha()))
            throw new RuntimeException("Acesso negado.");

        return tokenService.create(credentials);
    }
}
