package demo.nowadev.apijwt.jose;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtils {

  private KeyGeneratorUtils() {
  }

  static KeyPair generateRsaKey() {
    KeyPair keyPair;
    try {
      KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA"); // Generamos la Key con el algoritmo RSA
      generator.initialize(2048); // size
      keyPair = generator.generateKeyPair();
    
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
    return keyPair;
  }

}
