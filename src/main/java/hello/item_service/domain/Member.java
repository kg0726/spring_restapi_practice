package hello.item_service.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long memberId;
    private String loginId;
    private String password;
    private String name;
}
