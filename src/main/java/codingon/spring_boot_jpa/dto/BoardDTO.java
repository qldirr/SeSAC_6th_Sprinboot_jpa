package codingon.spring_boot_jpa.dto;

import lombok.*;

@Getter // getter 메서드
@NoArgsConstructor // 매개변수 없는 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@Builder // 빌더 패턴 사용 가능하도록 함
public class BoardDTO {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private int no;
}
