package mystudy.mystudyspring.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class UserDataCreateRequestDto {

    @NonNull
    private String name;

    private String content;

}
