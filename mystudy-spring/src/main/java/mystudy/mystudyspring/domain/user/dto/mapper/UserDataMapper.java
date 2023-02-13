package mystudy.mystudyspring.domain.user.dto.mapper;

import mystudy.mystudyspring.domain.user.domain.UserData;
import mystudy.mystudyspring.domain.user.dto.request.UserDataCreateRequestDto;
import mystudy.mystudyspring.domain.user.dto.request.UserDataUpdateRequestDto;
import mystudy.mystudyspring.domain.user.dto.response.UserDataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataMapper {

    public UserDataResponseDto toResponseDto(UserData data){
        return UserDataResponseDto.builder()
                .id(data.getId())
                .name(data.getName())
                .content(data.getContent())
                .build();
    }

    public UserData toEntity(UserDataUpdateRequestDto dto) {
        return UserData.builder()
                .id(dto.getId())
                .name(dto.getName())
                .content(dto.getContent())
                .build();
    }

    public UserData toEntity(UserDataCreateRequestDto dto) {
        return UserData.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .build();
    }
}