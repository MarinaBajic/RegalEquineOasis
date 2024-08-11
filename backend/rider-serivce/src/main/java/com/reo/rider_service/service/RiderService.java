package com.reo.rider_service.service;

import com.reo.rider_service.dto.RiderResponse;
import com.reo.rider_service.mapper.RiderMapper;
import com.reo.rider_service.model.Rider;
import com.reo.rider_service.repository.RiderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RiderService {

    private RiderRepository riderRepository;

    private RiderMapper riderMapper;

//    @Autowired
//    private CoachRepository coachRepository;

    public List<RiderResponse> getAll() {
        List<Rider> riders = riderRepository.findAll();
        return riderMapper.mapToResponseList(riders);
    }

//    private RiderResponse mapToRiderResponse(Rider rider) {
//        return RiderResponse.builder()
//                .idRider(rider.getIdRider())
//                .address(rider.getAddress())
//                .dateOfBirth(rider.getDateOfBirth())
//                .dateOfEnrollment(rider.getDateOfEnrollment())
//                .name(rider.getName())
//                .surname(rider.getSurname())
//                .coachName(rider.getCoach().getName() + " " + rider.getCoach().getSurname())
//                .build();
//    }

//    public void addNewRider(RiderRequest riderRequest) {
//        Optional<Coach> defaultCoachOptional = coachRepository.findByNameAndSurname("Marina", "Bajic");
//        Coach defaultCoach;
//        if (defaultCoachOptional.isEmpty()) {
//            defaultCoach = Coach.builder().name("Marina").surname("Bajic").build();
//            coachRepository.save(defaultCoach);
//        }
//        else
//            defaultCoach = defaultCoachOptional.get();
//
//        Rider rider = Rider.builder()
//                .address(riderRequest.getAddress())
//                .dateOfBirth(riderRequest.getDateOfBirth())
//                .dateOfEnrollment(riderRequest.getDateOfEnrollment())
//                .name(riderRequest.getName())
//                .surname(riderRequest.getSurname())
//                .coach(coachRepository.findById(riderRequest.getIdCoach()).orElse(defaultCoach))
//                .build();
//
//        riderRepository.save(rider);
//        log.info("Rider with id: {} is saved", rider.getIdRider());
//    }
}
