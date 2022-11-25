package mystudy.mystudyspring.domain.test.dto.mapper;

import mystudy.mystudyspring.domain.test.domain.TestData;
import mystudy.mystudyspring.domain.test.dto.request.TestDataCreateRequestDto;
import mystudy.mystudyspring.domain.test.dto.request.TestDataUpdateRequestDto;
import mystudy.mystudyspring.domain.test.dto.response.TestDataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataMapper {

    public TestDataResponseDto toResponseDto(TestData data){
        return TestDataResponseDto.builder()
                .id(data.getId())
                .name(data.getName())
                .content(data.getContent())
                .build();
    }

    public TestData toEntity(TestDataUpdateRequestDto dto) {
        return TestData.builder()
                .id(dto.getId())
                .name(dto.getName())
                .content(dto.getContent())
                .build();
    }

    public TestData toEntity(TestDataCreateRequestDto dto) {
        return TestData.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .build();
    }
}