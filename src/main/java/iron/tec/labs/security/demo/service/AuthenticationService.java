package iron.tec.labs.security.demo.service;

import iron.tec.labs.security.demo.dto.AuthenticationResponse;
import iron.tec.labs.security.demo.dto.LoginRequest;
import iron.tec.labs.security.demo.dto.SignUpRequest;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest loginRequest);
    AuthenticationResponse signUp(SignUpRequest signUpRequest);

}
