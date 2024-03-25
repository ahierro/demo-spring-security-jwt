package iron.tec.labs.security.demo.service;

import iron.tec.labs.security.demo.dto.PageResponseDTO;
import iron.tec.labs.security.demo.dto.SignUpRequest;
import iron.tec.labs.security.demo.dto.UserDTO;
import iron.tec.labs.security.demo.model.Role;
import iron.tec.labs.security.demo.model.User;
import iron.tec.labs.security.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.ErrorResponseException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    ConversionService conversionService;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void loadUserByUsername() {
        User existingUser = User.builder().id(1L).name("maria").password("asdas1").role(Role.USER).build();
        when(userRepository.getFirstByName(any())).thenReturn(existingUser);

        UserDetails userDetails = userService.loadUserByUsername("maria");

        assertNotNull(userDetails);
        assertEquals("maria", userDetails.getUsername());
    }

    @Test
    void loadUserByUsername_nonExistent_throwsException() {
        when(userRepository.getFirstByName(any())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("maria"));
    }

    @Test
    void createUser() {
        User newUser = User.builder().id(1L).name("ads").password("dssd").role(Role.USER).build();
        when(userRepository.save(any())).thenReturn(newUser);

        UserDetails userDetails = userService.createUser(SignUpRequest.builder().username("ads").password("dssd").build());

        verify(passwordEncoder).encode(any());
        assertNotNull(userDetails);
    }

    @Test
    void createUser_alreadyExisting_throwsException() {
        when(userRepository.save(any())).thenThrow(DataIntegrityViolationException.class);
        SignUpRequest signUpRequest = SignUpRequest.builder().username("ads").password("dssd").build();

        assertThrows(ErrorResponseException.class, () ->
                userService.createUser(signUpRequest));
    }

    @Test
    void getUsers() {
        User newUser = User.builder().id(1L).name("ads").password("dssd").role(Role.USER).build();
        UserDTO newUserDTO = UserDTO.builder().userName("ads").role(Role.USER.name()).build();

        PageRequest pageRequest = PageRequest.of(0,10);
        Page<User> userPage = new PageImpl<>(List.of(newUser),pageRequest,1);
        when(userRepository.findAll(any(Pageable.class))).thenReturn(userPage);
        when(conversionService.convert(any(User.class),eq(UserDTO.class))).thenReturn(newUserDTO);

        PageResponseDTO<UserDTO> responseDTO =
                userService.getUsers(pageRequest);

        assertNotNull(responseDTO);
        verify(conversionService).convert(any(User.class),eq(UserDTO.class));
    }
}