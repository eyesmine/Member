package com.member.admin.domain.members;

import com.member.admin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Members extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 50, nullable = false)
    private String pw;

    @Builder
    public Members(String userId, String pw) {
        this.userId = userId;
        this.pw = pw;
    }

    public void update(String pw) {
        this.pw = pw;
    }
}
