package ugtsic.sesaprn.testedesenv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TesteDesenvApplication implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register resource handler for images
        registry.addResourceHandler("/arquivos/**").addResourceLocations("/WEB-INF/arquivos/");
    }

    public static void main(String[] args) {
        SpringApplication.run(TesteDesenvApplication.class, args);
    }

}
