package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {
    private Long id;
    private String tripName;
    private String startDate;
    private String endDate;
    private Long user_id;
    List<DestinationDTO> destinationDTOS = new ArrayList<>();
}
