package mystudy.mystudyspring.domain.test.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TestDataResponseDto {

    @NonNull
    private UUID id;

    @NonNull
    private String name;

    private String content;
}
