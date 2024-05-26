package org.example.gymkhanabackend.repo;

import org.example.gymkhanabackend.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface MembersRepo extends JpaRepository<Members, Long> {
    Long countByMembershipType_MembershipTypeId(Integer membershipTypeId);


    @Query("SELECT m FROM Members m WHERE m.membershipEndDate < :today")
    List<Members> findByMembershipEndDateBefore(@Param("today") LocalDate today);
}
