package iron.tec.labs.security.demo.service;

import iron.tec.labs.security.demo.dto.PageResponseDTO;
import iron.tec.labs.security.demo.dto.SignUpRequest;
import iron.tec.labs.security.demo.dto.UserDTO;
import iron.tec.labs.security.demo.model.User;
import iron.tec.labs.security.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import static iron.tec.labs.security.demo.model.Role.USER;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.getFirstByName(userName);
        if (userDetails ==null){
            throw new UsernameNotFoundException(userName);
        }
        return userDetails;
    }

    @Override
    public UserDetails createUser(SignUpRequest signUpRequest) {
        try{
            return userRepository.save(User.builder()
                    .name(signUpRequest.getUsername())
                    .password(passwordEncoder.encode(signUpRequest.getPassword()))
                    .role(USER)
                    .build());
        }catch (DataIntegrityViolationException e){
            throw new ErrorResponseException(HttpStatus.CONFLICT,
                    ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
                            "User already exist"),e);
        }
    }

    @Override
    public PageResponseDTO<UserDTO> getUsers(Pageable pageable) {

        Page<User> userPage = userRepository.findAll(pageable);
        return new PageResponseDTO<>(
                userPage.getContent().stream()
                        .map(user -> conversionService.convert(user, UserDTO.class)).toList()
                , userPage.getPageable()
                , userPage.getTotalPages());
    }


}
