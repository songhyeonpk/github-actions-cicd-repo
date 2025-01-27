package com.sh.cicd.domain.user.domain;

import com.sh.cicd.domain.common.BaseTimeEntity;
import com.sh.cicd.domain.common.vo.UserDetailVo;
import com.sh.cicd.domain.common.vo.UserInfoVo;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "tbl_users")
@Builder
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public UserInfoVo toUserInfoVo() {
        return UserInfoVo.from(this);
    }

    public UserDetailVo toUserDetailVo() {
        return UserDetailVo.from(this);
    }
}
