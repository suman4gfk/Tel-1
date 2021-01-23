package com.infosys.wecare.repository;

import com.infosys.wecare.entity.CoachEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, String> {
    public Optional<CoachEntity> findByCoachId(String coachId);

}
