package iron.tec.labs.security.demo.service;

import iron.tec.labs.security.demo.dto.PageResponseDTO;
import iron.tec.labs.security.demo.dto.SignUpRequest;
import iron.tec.labs.security.demo.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDetails createUser(SignUpRequest signUpRequest);

    PageResponseDTO<UserDTO> getUsers(Pageable pageable);
}
