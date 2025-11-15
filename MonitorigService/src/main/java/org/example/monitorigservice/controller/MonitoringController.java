package org.example.monitorigservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.monitorigservice.dto.DeviceDTO;
import org.example.monitorigservice.service.MonitoringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/monitoring")
public class MonitoringController {
    private final MonitoringService monitoringService;

    @PostMapping
    public ResponseEntity<?> insertDevice(@RequestBody DeviceDTO deviceDTO){
        try{
            return ResponseEntity.ok(monitoringService.insertDevice(deviceDTO));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable Long id){
        try{
            monitoringService.deleteDevice(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

}
