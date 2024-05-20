package org.example.gymkhanabackend.service;

import org.example.gymkhanabackend.entity.Members;
import org.example.gymkhanabackend.pojo.MembersPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MembersService {
    void saveData(MembersPojo membersPojo);
    List<Members> getAll();

    void deleteById(Integer id);
    Optional<Members> findById(Integer id);
}
