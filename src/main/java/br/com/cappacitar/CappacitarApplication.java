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
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(CappacitarApplication.class, args);
		// Cria uma instância do BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        // Define a senha a ser criptografada
        String rawPassword = "123";
        
        // Criptografa a senha
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        // Imprime a senha criptografada
        System.out.println("Senha criptografada: " + encodedPassword);
	}
	
//	/* MAPEAMENTO GLOBAL DO CORS QUE REFLETE em todo SISTEMA*/
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//		.allowedMethods("*")
//		.allowedOrigins("*");
//	}

}
