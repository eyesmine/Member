package com.member.admin.domain.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MemberRepository extends JpaRepository<Members, Long> {
    @Query("SELECT p FROM Members p ORDER BY p.id DESC")
    List<Members> findAllDesc();

}
