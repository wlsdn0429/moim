package project.moim.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // BaseTimeEntity를 상속한 엔티티들은 아래 필드들을 컬럼으로 인식하게 된다.
@EntityListeners(AuditingEntityListener.class) // Auditing(자동으로 값 매핑) 기능 추가
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false) // Entity가 Update 될 때 created_at이 update가 되지 않게하기위해 작성
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;
}
