package codingon.spring_boot_jpa.service;

import codingon.spring_boot_jpa.dto.UserDTO;
import codingon.spring_boot_jpa.entity.User;
import codingon.spring_boot_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUserss() {
        // 1. Repository 계층에서 모든 User 리스트 가져옴
        List<User> users = userRepository.findAll();

        // 2. 새로운 DTO 객체 리스트 생성
        List<UserDTO> userDTOS = new ArrayList<>();

        // 3. 반복문을 이용해 User 객체를 UserDTO객체로 변환하고 리스트에 추가
        for (User user : users) {
            UserDTO userDTO = convertToDTO(user);
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

    public UserDTO getUserById(Long id){
        // JPA가 기본 제공하는 findById 메서드로 특정 유저를 찾으면
        // 그 User 객체를 반환함
        // 만약, 사용자를 찾지 못하면 null 반환
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new RuntimeException("User not found");
        }

        return convertToDTO(user);
    }

    // entity(domain) to dto
    private UserDTO convertToDTO(User user) {
        return UserDTO.builder().id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .no((int) (user.getId() + 100))
                .build();
    }
}

