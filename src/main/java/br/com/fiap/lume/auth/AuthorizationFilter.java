package br.com.fiap.lume.auth;

import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.lume.Cliente.Cliente;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;

    public AuthorizationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var header = request.getHeader("Authorization");
        if (header == null) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!header.startsWith("Bearer ")) {
            response.setStatus(401);
            response.addHeader("Content-Type", "application/json");
            response.getWriter().write("""
                        {
                            "message":"Token must start with 'Bearer '"
                        }
                    """);
            return;
        }

        try {
            var token = header.replace("Bearer ", "");
            Cliente cliente = tokenService.getClienteFromToken(token);

            var auth = new UsernamePasswordAuthenticationToken(
                    cliente.getEmail(),
                    cliente.getSenha());
            SecurityContextHolder.getContext().setAuthentication(auth);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(401);
            response.addHeader("Content-Type", "application/json");
            response.getWriter().write("""
                        {
                            "message": "%s"
                        }
                    """.formatted(e.getMessage()));
        }
    }
}