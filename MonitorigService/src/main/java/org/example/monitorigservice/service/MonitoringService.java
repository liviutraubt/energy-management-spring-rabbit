package org.example.monitorigservice.service;

import lombok.RequiredArgsConstructor;
import org.example.monitorigservice.dto.DeviceDTO;
import org.example.monitorigservice.entity.DeviceEntity;
import org.example.monitorigservice.mapper.DeviceMapper;
import org.example.monitorigservice.mapper.MonitoringMapper;
import org.example.monitorigservice.repository.DeviceRepository;
import org.example.monitorigservice.repository.MonitoringRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonitoringService {
    private final DeviceRepository deviceRepository;
    private final MonitoringRepository monitoringRepository;
    private final DeviceMapper deviceMapper;
    private final MonitoringMapper monitoringMapper;

    public Long insertDevice(DeviceDTO deviceDTO) {
        if(deviceRepository.existsById(deviceDTO.getId())) {
            throw new RuntimeException("Device already exists");
        }
        DeviceEntity deviceEntity = deviceMapper.deviceDTOToDeviceEntity(deviceDTO);
        return deviceRepository.save(deviceEntity).getId();
    }

    public void deleteDevice(Long  deviceId) {
        if(!deviceRepository.existsById(deviceId)) {
            throw new RuntimeException("Device doesn't exists");
        }
        deviceRepository.deleteById(deviceId);
    }
}
