package iron.tec.labs.security.demo.controller;

import iron.tec.labs.security.demo.dto.AuthenticationResponse;
import iron.tec.labs.security.demo.dto.LoginRequest;
import iron.tec.labs.security.demo.dto.SignUpRequest;
import iron.tec.labs.security.demo.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(summary = "Login with user and password and returns JWT token", responses = {
            @ApiResponse(responseCode = "200",description = "Successful Operation", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content)})

    @PostMapping("/api/login")
    @PreAuthorize("permitAll()")
    public AuthenticationResponse login(@RequestBody @Valid @NonNull LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @Operation(summary = "Sign up and returns JWT token", responses = {
            @ApiResponse(responseCode = "200",description = "Successful Operation", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content)})
    @PostMapping("/api/sign-up")
    @PreAuthorize("permitAll()")
    public AuthenticationResponse signUp(@RequestBody @Valid @NonNull SignUpRequest signUpRequest) {
        return authenticationService.signUp(signUpRequest);
    }

}
