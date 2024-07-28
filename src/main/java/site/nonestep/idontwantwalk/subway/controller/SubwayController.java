package site.nonestep.idontwantwalk.subway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.nonestep.idontwantwalk.subway.dto.SubwayElevatorRequestDTO;
import site.nonestep.idontwantwalk.subway.dto.SubwayElevatorResponseDTO;
import site.nonestep.idontwantwalk.subway.dto.SubwayLocationRequestDTO;
import site.nonestep.idontwantwalk.subway.dto.SubwayLocationResponseDTO;
import site.nonestep.idontwantwalk.subway.service.SubwayService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/subway")
public class SubwayController {

    @Autowired
    private SubwayService subwayService;

    // 위치 기반 역 조회 및 검색
    @GetMapping("/location")
    public ResponseEntity<?> location(@ModelAttribute SubwayLocationRequestDTO subwayLocationRequestDTO){
        List<SubwayLocationResponseDTO> subwayLocationResponseDTO = subwayService.location(subwayLocationRequestDTO.getLatitude(),
                subwayLocationRequestDTO.getLongitude(), subwayLocationRequestDTO.getRadius());

        return new ResponseEntity<>(subwayLocationResponseDTO, HttpStatus.OK);
    }

    // 역 1개의 정보 전체 조회

    // 엘리베이터 있는 역 조회
    @GetMapping("/elevator")
    public ResponseEntity<?> elevator(@ModelAttribute SubwayElevatorRequestDTO subwayElevatorRequestDTO){
        List<SubwayElevatorResponseDTO> subwayElevatorResponseDTO = subwayService.elevator(subwayElevatorRequestDTO.getLatitude(),
                subwayElevatorRequestDTO.getLongitude(), subwayElevatorRequestDTO.getRadius());

        return new ResponseEntity<>(subwayElevatorResponseDTO, HttpStatus.OK);
    }


}
