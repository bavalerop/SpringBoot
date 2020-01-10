package com.hotel.config;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {
	

	
	@Bean
    public OpenAPI customOpenAPI() {
		//Objetos de Informacion
		//Obj Contacto
		Contact con = new Contact();
		con.setName("Brayan Valero");
		con.setUrl("https://www.facebook.com/brayanandres.valeropinzon");
		con.setEmail("bavalerop@gmail.com");
		//Obj Lincence
		License li = new License();
		li.setName(" Apache 2.0");
		li.setUrl("https://www.apache.org/licenses/LICENSE-2.0.html");
		List<Server> serv = new ArrayList<Server>();
		Server s1 = new Server();
		Server s2 = new Server();
		s1.setUrl("http://localhost:8083/");
		s1.setDescription("local");
		s2.setUrl("http://192.168.0.4:8088/");
		s2.setDescription("produccion");
		serv.add(s1);
		serv.add(s2);
        return new OpenAPI()
        		.servers(serv)
        		.components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                		.title("Spring Boot REST API Hotel")
                		.description("API para el manejo de Hoteles")
                		.version("1.0.1")
                		.contact(con)
                		.license(li)
                );
    }
}
