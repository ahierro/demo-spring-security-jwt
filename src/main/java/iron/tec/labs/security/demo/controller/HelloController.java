package iron.tec.labs.security.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello World Operations")
public class HelloController {

    @Operation(security = { @SecurityRequirement(name = "bearer-key") },
            summary = "Welcome normal user", responses = {
            @ApiResponse(responseCode = "200",description = "Successful Operation", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @GetMapping(value = "/hello/user")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    public String user(Authentication authentication){
        return welcomeLoggedUser(authentication);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") },
            summary = "Welcome admin user", responses = {
            @ApiResponse(responseCode = "200",description = "Successful Operation", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @GetMapping(value = "/hello/admin")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String admin(Authentication authentication){

        return welcomeLoggedUser(authentication);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") },
            summary = "Welcome any logged user", responses = {
            @ApiResponse(responseCode = "200",description = "Successful Operation", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)})
    @GetMapping(value = "/hello/any")
    public String any(Authentication authentication){

        return welcomeLoggedUser(authentication);
    }

    private static String welcomeLoggedUser(Authentication authentication) {
        return "Welcome " + authentication.getName();
    }

}
