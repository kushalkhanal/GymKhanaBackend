package org.example.gymkhanabackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class MembershipType {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer membershipTypeId;
        private String typeName;
        private Integer duration;  // in months
        private Double price;


        //
//    @OneToMany(mappedBy = "membershipType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonBackReference  // Added to break circular reference

//    private List<Members> members;
}
