package org.example.monitorigservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MonitoringDTO {
    private Long id;
    private LocalDateTime timestamp;
    private Double consumption;
    private DeviceDTO device;
}
