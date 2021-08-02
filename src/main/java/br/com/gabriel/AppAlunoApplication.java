package br.com.gabriel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppAlunoApplication {
    /*
    @Bean
    public CommandLineRunner run ( @Autowired ClienteRepository repository ) {
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setCpf("0000000001");
            cliente.setNome("Fulano");
            repository.save(cliente);
        };
    }*/

    public static void main(String[] args) {
        SpringApplication.run(AppAlunoApplication.class, args);
    }
}
