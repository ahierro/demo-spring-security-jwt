package iron.tec.labs.security.demo.service;

import iron.tec.labs.security.demo.dto.AuthenticationResponse;
import iron.tec.labs.security.demo.dto.LoginRequest;
import iron.tec.labs.security.demo.dto.SignUpRequest;
import iron.tec.labs.security.demo.jwt.JWTGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JWTGeneratorService jwtGeneratorService;
    private final UserService userService;

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        String jwt = jwtGeneratorService
                .generateToken(authentication);

        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }

    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        UserDetails userDetails = userService.createUser(signUpRequest);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, userDetails, userDetails.getAuthorities());
        return AuthenticationResponse.builder()
                .jwt(jwtGeneratorService
                        .generateToken(authentication))
                .build();
    }
}
