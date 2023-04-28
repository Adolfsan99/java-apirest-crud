package demo.nowadev.apijwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.nowadev.apijwt.service.TokenService;

@RestController
public class AuthController {

  // Creamos un logger para desplegar los datos
  private static final Logger LOG = (Logger) LoggerFactory.getLogger(AuthController.class);
  private final TokenService tokenService;

  public AuthController(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  @PostMapping("/token")
  public String token(Authentication authentication) {

    LOG.debug("Token request for user: '{}'", authentication.getName());

    /*
     * Creamos la token a partir de los datos del usuario
     */

    String token = tokenService.generateToken(authentication);

    LOG.debug("Token: {}", token);
    return token;
  }

}
