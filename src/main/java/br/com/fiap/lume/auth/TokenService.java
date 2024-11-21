package br.com.fiap.lume.auth;

import br.com.fiap.lume.Cliente.Cliente;
import br.com.fiap.lume.Cliente.ClienteRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {

    private final ClienteRepository repository;
    private Algorithm algorithm;

    public TokenService(ClienteRepository repository, @Value("${jwt.secret}") String secret) {
        this.repository = repository;
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public Token create(Credentials credentials){
        var expireAt = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-3));
        var token = JWT.create()
        .withSubject(credentials.email())
        .withExpiresAt(expireAt)
        .sign(algorithm);
        return new Token(token, credentials.email());
    }
    public Cliente getClienteFromToken(String token){
        var email = JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();

        return repository.findByEmail(email).orElseThrow(
            () -> new UsernameNotFoundException("Cliente não encontrado")
        );
    }
}