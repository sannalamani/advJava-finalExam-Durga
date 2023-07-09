package fr.epita.web;

import fr.epita.advjava.FacilityDAO;
import fr.epita.advjava.datamodel.Facility;
import fr.epita.app.FacilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilitiesRestController {

    @Autowired
    private final FacilityDAO facilityDAO;

    public FacilitiesRestController(FacilityDAO facilityDAO) {
        this.facilityDAO = facilityDAO;
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityDAO.getAllFacilities();
    }


    }
//    @PostMapping
//    public void createFacility(@RequestBody FacilityDTO facilityDTO) {
//        Facility facility = new Facility();
//        facility.setName(facilityDTO.getName());
//        facility.setMemberCost(facilityDTO.getMemberCost());
//        facility.setGuestCost(facilityDTO.getGuestCost());
//        facility.setInitialOutlay(facilityDTO.getInitialOutlay());
//        facility.setMonthlyMaintenance(facilityDTO.getMonthlyMaintenance());
//
//        facilityDAO.createFacility(facility);
//    }

