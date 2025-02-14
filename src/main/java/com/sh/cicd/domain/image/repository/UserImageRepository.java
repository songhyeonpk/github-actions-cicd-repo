package com.sh.cicd.domain.image.repository;

import com.sh.cicd.domain.image.domain.UserImageEntity;
import com.sh.cicd.domain.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserImageRepository extends JpaRepository<UserImageEntity, Long> {

    Optional<UserImageEntity> findByUserId(Long userId);
}
