package org.example.gymkhanabackend.repo;

import org.example.gymkhanabackend.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MembersRepo extends JpaRepository<Members, Long> {
}
