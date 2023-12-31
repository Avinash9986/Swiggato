package com.example.swiggato.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestarauntResponse {

    String name ;

    String location ;

    String contactNumber ;

    boolean opened ;

    List<MenuResponse> menu ;

}
