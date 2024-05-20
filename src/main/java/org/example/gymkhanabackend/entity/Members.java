package org.example.gymkhanabackend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "members_table")
public class Members {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="members_seq_gen")
    @SequenceGenerator(name="members_seq_gen",sequenceName="members_seq",allocationSize=1)

    @Id
    private Integer memberId;
    @Column(name="name" ,nullable=false, length=100)
    private String name;
    @Column(name="email" ,nullable=false, length=100)
    private String email;
    @Column(name="phone_number" ,nullable=false, length=100)
    private String phoneNumber;
    @Column(name="address" ,nullable=false, length=100)
    private String address;
    @Column(name="date_of_birth" ,nullable=false, length=100)
    private LocalDate dateOfBirth;
    @Column(name="created_at" ,nullable=false, length=100)
    private LocalDateTime createdAt;
    @Column(name="membership_Start_Date" ,nullable=false, length=100)
    private LocalDate membershipStartDate;
    @Column(name="membership_End_Date" ,nullable=false, length=100)
    private LocalDate membershipEndDate;
//    @Column(name="profile_img" ,nullable=true, length=100)
//    private String profileImg;

    //--Used to fetch the data from the membership
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membership_type_id")
//    @JsonManagedReference  // Added to break circular reference

    private MembershipType membershipType;

//    public MembershipTypePojo membershipTypePojo;





}
