package br.com.cappacitar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CappacitarApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CappacitarApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CappacitarApplication.class, args);
		
		 // Criptografar a senha
        String senha = "plhuser1";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(senha);

        // Imprimir a senha criptografada no console
        System.out.println("Senha criptografada: " + senhaCriptografada);
		
	}

}
