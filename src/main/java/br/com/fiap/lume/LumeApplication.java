package br.com.fiap.lume;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Lumi API",
                version = "1.0.0",
                description = "API de gastos energéticos",
                contact = @Contact(name = "Leonardo Seiti", url = "https://www.linkedin.com/in/leonardoseiti/")
        )
)
public class LumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumeApplication.class, args);
    }

    @RequestMapping
    @ResponseBody
    public String home(){
        return "Projeto Emi";
    }
}
