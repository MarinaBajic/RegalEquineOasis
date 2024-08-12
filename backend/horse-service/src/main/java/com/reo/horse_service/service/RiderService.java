package com.reo.horse_service.service;

import com.reo.horse_service.feign.RiderManagementClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RiderService {

    private RiderManagementClient riderManagementClient;

    public void deleteCascadeHorseInfo(Long idHorse) {
        riderManagementClient.deleteSessionByHorseId(idHorse);
        riderManagementClient.deleteFavoriteByHorseId(idHorse);
    }
}
