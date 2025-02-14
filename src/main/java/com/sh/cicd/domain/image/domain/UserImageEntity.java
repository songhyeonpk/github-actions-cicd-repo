package com.sh.cicd.domain.image.domain;

import com.sh.cicd.domain.common.BaseTimeEntity;
import com.sh.cicd.domain.user.domain.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.sh.cicd.common.consts.StaticConsts.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "tbl_user_image")
@Builder
public class UserImageEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String uri;

    private String objectKey;

    public void delete() {
        this.uri = IMAGE_DOMAIN + "/" + USER_DEFAULT_IMAGE;
        this.objectKey = USER_DEFAULT_IMAGE;
    }
}
