package com.sh.cicd.domain.image.repository;

import com.sh.cicd.domain.image.domain.UserImageEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserImageRepository extends JpaRepository<UserImageEntity, Long> {

    Optional<UserImageEntity> findByUserId(Long userId);
}
