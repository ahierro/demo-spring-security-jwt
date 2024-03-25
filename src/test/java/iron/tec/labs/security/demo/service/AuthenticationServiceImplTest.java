package iron.tec.labs.security.demo.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {
//    private static final String JWT_EXAMPLE = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJudWxsIiwiaWF0IjoxNjg1MDQ3NzY0LCJleHAiOjE2ODUwNDg5NjR9.fgSG8gKJvGzt0Weq1n_049w4Dxakc7XBm-R8oqRLTpI";
//    @Mock
//    AuthenticationManager authenticationManager;
//    @Mock
//    UserService userService;
//    @Mock
//    JwtService jwtService;
//
//    @InjectMocks
//    AuthenticationServiceImpl authenticationService;
//
//    @Test
//    void login() {
//        User existingUser = User.builder().id(1L).name("pedro").password("asdas").role(Role.USER).build();
//        Authentication authenticationMock = Mockito.mock(Authentication.class);
//        when(authenticationManager.authenticate(any())).thenReturn(authenticationMock);
//        when(authenticationMock.getPrincipal()).thenReturn(existingUser);
//        when(jwtService.generateToken(existingUser)).thenReturn(JWT_EXAMPLE);
//
//        AuthenticationResponse authenticationResponse =
//                authenticationService.login(LoginRequest.builder().username("testuser").password("213").build());
//
//        assertNotNull(authenticationResponse);
//        assertEquals(JWT_EXAMPLE,authenticationResponse.getJwt());
//    }
//
//    @Test
//    void signUp() {
//        User newUser = User.builder().id(1L).name("pedro").password("asdas").role(Role.USER).build();
//        when(userService.createUser(any())).thenReturn(newUser);
//        when(jwtService.generateToken(newUser)).thenReturn(JWT_EXAMPLE);
//
//        AuthenticationResponse authenticationResponse =
//                authenticationService.signUp(SignUpRequest.builder().username("testuser").password("213").build());
//
//        assertNotNull(authenticationResponse);
//        assertEquals(JWT_EXAMPLE,authenticationResponse.getJwt());
//    }
}