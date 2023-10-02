package com.example.swiggato.dto.request;

import com.example.swiggato.Enum.RestarauntCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestarauntRequest {
    String name ;

    String location ;

    RestarauntCategory restarauntCategory ;

    String contactNumber ;

}
