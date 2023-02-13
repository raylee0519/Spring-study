package mystudy.mystudyspring.domain.user.service;

import lombok.RequiredArgsConstructor;
import mystudy.mystudyspring.domain.user.dao.UserRepository;
import mystudy.mystudyspring.domain.user.domain.UserData;
import mystudy.mystudyspring.domain.user.dto.mapper.UserDataMapper;
import mystudy.mystudyspring.domain.user.dto.request.UserDataCreateRequestDto;
import mystudy.mystudyspring.domain.user.dto.request.UserDataUpdateRequestDto;
import mystudy.mystudyspring.domain.user.exception.NotFoundUserDataEntityException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor // final 멤버 변수용 생성자
public class UserService {

    private final UserRepository userRepository;
    private final UserDataMapper mapper;

    public UserData create(UserDataCreateRequestDto dto){

        UserData entity = mapper.toEntity(dto);
        return userRepository.save(entity);
    }

    public UserData findById(UUID id) {
        return findUserDataById(id);
    }

    public void deleteById(UUID id){
        userRepository.deleteById(id);
    }

    public UserData update(UserDataUpdateRequestDto dto) {
        UserData newUserData = findUserDataById(dto.getId());
        newUserData.update(dto.getName(), dto.getContent());
        return userRepository.save(newUserData);
    }

    private UserData findUserDataById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                NotFoundUserDataEntityException::new
        );
    }

}
