package mystudy.mystudyspring.domain.test.dto.request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class TestDataCreateRequestDto {

    @NonNull
    private String name;

    private String content;

}
