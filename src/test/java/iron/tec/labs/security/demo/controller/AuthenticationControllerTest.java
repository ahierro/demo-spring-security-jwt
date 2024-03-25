package iron.tec.labs.security.demo.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(AuthenticationController.class)
class AuthenticationControllerTest {
//
//    public static final String JWT_EXAMPLE = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4NTA0NzczMCwiZXhwIjoxNjg1MDQ4OTMwfQ.woVZr6L87DOlwg_qf_viNdMSgLwhItdEjhbXJQkILK0";
//
//    @MockBean
//    JwtRequestFilter jwtRequestFilter;
//
//    @MockBean
//    AuthenticationService authenticationService;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    AuthenticationController authenticationController;
//
//    @Test
//    void login() throws Exception {
//        ArgumentCaptor<LoginRequest> argumentCaptor = ArgumentCaptor.forClass(LoginRequest.class);
//        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
//                .jwt(JWT_EXAMPLE).build();
//        when(authenticationService.login(argumentCaptor.capture())).thenReturn(authenticationResponse);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                                {
//                                    "username":"admin",
//                                    "password":"adminPass"
//                                }
//                                """))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.jwt").value(JWT_EXAMPLE));
//
//        verify(authenticationService).login(any());
//
//        assertEquals("admin", argumentCaptor.getValue().getUsername());
//        assertEquals("adminPass", argumentCaptor.getValue().getPassword());
//    }
//
//    @Test
//    void signUp() throws Exception {
//        ArgumentCaptor<SignUpRequest> argumentCaptor = ArgumentCaptor.forClass(SignUpRequest.class);
//        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
//                .jwt(JWT_EXAMPLE).build();
//        when(authenticationService.signUp(argumentCaptor.capture())).thenReturn(authenticationResponse);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/sign-up")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                                {
//                                    "username":"admin",
//                                    "password":"adminPass"
//                                }
//                                """))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.jwt").value(JWT_EXAMPLE));
//
//        verify(authenticationService).signUp(any());
//
//        assertEquals("admin", argumentCaptor.getValue().getUsername());
//        assertEquals("adminPass", argumentCaptor.getValue().getPassword());
//    }
}

