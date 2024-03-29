package study.datajpa.dto;

import lombok.Data;
import study.datajpa.entity.Member;

@Data // getter, setter 다 들어가 있으므로 웬만하면 안쓰는게 좋음
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }

    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.teamName = member.getTeam().getName();
    }
}
