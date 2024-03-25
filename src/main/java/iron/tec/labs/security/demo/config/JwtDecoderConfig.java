package iron.tec.labs.security.demo.config;

import iron.tec.labs.security.demo.jwt.JwtConfig;
import com.nimbusds.jose.JWSAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@AllArgsConstructor
public class JwtDecoderConfig {

    private final JwtConfig jwtConfig;

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withSecretKey(
                new SecretKeySpec(jwtConfig.secretKey().getBytes(),
                        JWSAlgorithm.RS256.getName())).build();
    }

}
