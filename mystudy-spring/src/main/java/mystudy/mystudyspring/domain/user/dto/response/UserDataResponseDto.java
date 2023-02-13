package mystudy.mystudyspring.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserDataResponseDto {

    @NonNull
    private UUID id;

    @NonNull
    private String name;

    private String content;
}
