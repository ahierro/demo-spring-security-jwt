package iron.tec.labs.security.demo.converters;

import iron.tec.labs.security.demo.dto.UserDTO;
import iron.tec.labs.security.demo.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOConverter implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(User source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(source.getName());
        userDTO.setRole(source.getRole().name());
        return userDTO;
    }

}
