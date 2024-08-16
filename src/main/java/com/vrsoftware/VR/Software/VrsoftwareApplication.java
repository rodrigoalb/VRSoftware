package com.vrsoftware.VR.Software;

import com.vrsoftware.VR.Software.gui.TelaInicial;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VrsoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(VrsoftwareApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			TelaInicial telaInicial = ctx.getBean(TelaInicial.class);

			telaInicial.setVisible(true);
		};
	}
}