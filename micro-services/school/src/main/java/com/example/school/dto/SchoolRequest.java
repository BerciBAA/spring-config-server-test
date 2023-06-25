package com.example.school.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SchoolRequest {
    private String name;
    private String email;
}
