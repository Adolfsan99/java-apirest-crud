package demo.nowadev.apijwt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/")
  public String test(Authentication authentication) {

    // TODO: hacer que nuestro nombre de usuario se despliege

    return "Bienvenido a la pagina de prueba de la autenticacion con JWT! tu nombre es: " + authentication.getName();
  }

}
