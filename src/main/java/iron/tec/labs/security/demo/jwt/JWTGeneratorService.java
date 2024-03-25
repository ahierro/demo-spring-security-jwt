package iron.tec.labs.security.demo.jwt;

import org.springframework.security.core.Authentication;

public interface JWTGeneratorService {
    String generateToken(Authentication authentication);
}
