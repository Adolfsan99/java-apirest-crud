package demo.nowadev.apijwt.jose;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import com.nimbusds.jose.jwk.RSAKey;

public class Jwks {

  private Jwks() {
  }

  public static RSAKey generateRsa() {

    /*
     * Generamos la KEY
     */

    KeyPair keyPair = KeyGeneratorUtils.generateRsaKey();
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    System.err.print("KEYS: \n\tPublic Key: " + publicKey + "\n\nPrivate Key: " + privateKey + "\n\n");

    return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();

  }

}
