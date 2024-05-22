package org.example.gymkhanabackend.service.implementor;

import lombok.RequiredArgsConstructor;
import org.example.gymkhanabackend.entity.Members;
import org.example.gymkhanabackend.pojo.MembersPojo;
import org.example.gymkhanabackend.repo.MembersRepo;
import org.example.gymkhanabackend.service.MembersService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MembersImpl implements MembersService {
    private final MembersRepo membersRepo;

    @Override
    public void saveData(MembersPojo membersPojo) {
        Members members = new Members();
        members.setMemberId(membersPojo.getMembersId());
        members.setName(membersPojo.getName());
        members.setEmail(membersPojo.getEmail());
        members.setPhoneNumber(membersPojo.getPhoneNumber());
        members.setAddress(membersPojo.getAddress());
        members.setDateOfBirth(membersPojo.getDateOfBirth());
        members.setMembershipStartDate(membersPojo.getMembershipStartDate());
        members.setMembershipEndDate(membersPojo.getMembershipEndDate());
        members.setCreatedAt(LocalDateTime.now());
        members.setMembershipType(membersPojo.getMembershipType());


        membersRepo.save(members);
    }

    @Override
    public List<Members> getAll() {
        return membersRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        membersRepo.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Members> findById(Integer id) {
        return membersRepo.findById(Long.valueOf(id));
    }

    public void update(Integer id, MembersPojo membersPojo) {
        Optional<Members> optionalMembers = membersRepo.findById(Long.valueOf(id));

        if (optionalMembers.isPresent()) {
            Members existingMembers = optionalMembers.get();

            existingMembers.setName(membersPojo.getName());
            existingMembers.setEmail(membersPojo.getEmail());
            existingMembers.setDateOfBirth(membersPojo.getDateOfBirth());
            existingMembers.setPhoneNumber(membersPojo.getPhoneNumber());
            existingMembers.setAddress(membersPojo.getAddress());
            existingMembers.setMembershipStartDate(membersPojo.getMembershipStartDate());
            existingMembers.setMembershipEndDate(membersPojo.getMembershipEndDate());
            existingMembers.setMembershipType(membersPojo.getMembershipType());

            membersRepo.save(existingMembers);

        }

    }

}
