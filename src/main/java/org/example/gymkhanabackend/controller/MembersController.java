package org.example.gymkhanabackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.gymkhanabackend.entity.Members;
import org.example.gymkhanabackend.pojo.MembersPojo;
import org.example.gymkhanabackend.service.MembersService;
import org.example.gymkhanabackend.shared.pojo.GlobalApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

@Validated
public class MembersController {
    private final MembersService membersService;


    @GetMapping("/get")
    public GlobalApiResponse<List<Members>> getData() {
        List<Members> list = membersService.getAll();

        return GlobalApiResponse.
                <List<Members>>builder()
                .data(list)
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }




    @PostMapping("/save")
    public GlobalApiResponse<String> save(@Validated @RequestBody MembersPojo membersPojo) {
        this.membersService.saveData(membersPojo);
        return GlobalApiResponse.
                <String>builder()
                .statusCode(200)
                .data("ok")
                .message("Member saved Successfully!")
                .build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GlobalApiResponse<Optional<Members>>> getData(@PathVariable Integer id) {
        Optional<Members> list = membersService.findById(id);

        if (list.isEmpty()) {
            return ResponseEntity.status(404).body(
                    GlobalApiResponse.<Optional<Members>>builder()
                            .data(list)
                            .statusCode(404)
                            .message("Data not found!")
                            .build()
            );
        }

        return ResponseEntity.ok(
                GlobalApiResponse.<Optional<Members>>builder()
                        .data(list)
                        .statusCode(200)
                        .message("Data retrieved successfully!")
                        .build()
        );
    }

    @DeleteMapping ("/delete/{id}")
    public GlobalApiResponse<String> delete(@Validated @PathVariable Integer id) {
        this.membersService.deleteById(id);
        return GlobalApiResponse.
                <String>builder()
                .statusCode(200)
                .data("ok")
                .message("Data deleted successfully!")
                .build();


    }

}
