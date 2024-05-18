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
    private Integer id;
    @Column(name="first_name" ,nullable=false, length=100)
    private String firstName;
    @Column(name="last_name" ,nullable=false, length=100)
    private String lastName;
    @Column(name="age" ,nullable=false, length=100)
    private Integer age;
    @Column(name="packages" ,nullable=false, length=100)
    private String packages;
    @Column(name="phone_number" ,nullable=false, length=100)
    private String phoneNumber;
    @Column(name="joined_on" ,nullable=false, length=100)
    private LocalDate joinedOn;
    @Column(name="address" ,nullable=false, length=100)
    private String address;
    @Column(name="date_of_birth" ,nullable=false, length=100)
    private LocalDate dateOfBirth;
    @Column(name="created_at" ,nullable=false, length=100)
    private LocalDateTime createdAt;



}
