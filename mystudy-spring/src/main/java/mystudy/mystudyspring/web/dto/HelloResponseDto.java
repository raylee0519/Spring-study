package mystudy.mystudyspring.web.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@JsonAnyGetter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
