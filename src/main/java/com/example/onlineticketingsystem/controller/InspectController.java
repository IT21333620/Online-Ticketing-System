package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.InspectDTO;
import com.example.onlineticketingsystem.entity.Inspect;
import com.example.onlineticketingsystem.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "api/Inspect")
public class InspectController {

    @Autowired
    private InspectService inspectService;


    @PostMapping("/createInspect")
    public InspectDTO saveInspect (@RequestBody InspectDTO inspectDTO){
        return inspectService.saveInspect(inspectDTO);
    }

    @GetMapping("/getInspect")
    public List<InspectDTO> getAllInspects(){
        return inspectService.getAllInspects();
    }

    @GetMapping("/byInspector/{id}")
    public List<Inspect> getInspectsByInspectorId(@PathVariable int id) {
        return inspectService.getInspectsByInspectorId(id);
    }

    @DeleteMapping("/deleteInspect")
    public boolean delete(@RequestBody InspectDTO inspectDTO) {
        return inspectService.delete(inspectDTO);
    }

    @PutMapping("/updateInspect")
    public InspectDTO updateInspect(@RequestBody InspectDTO inspectDTO){
        return inspectService.updateInspect(inspectDTO);
    }

    @GetMapping("/fraudCount")
    public int fraudCount(){
        return inspectService.fraudCount();
    }

    @GetMapping("/fraudByRoute")
    public Map<Integer, Integer> fraudByRoute(){
        return inspectService.fraudByRoute();
    }

    @GetMapping("/countTodayInspectors")
    public Map<Integer, Long>getCountOfInspectorIdByRouteToday(){
        return inspectService.getCountOfInspectorIdByRouteToday();
    }

    @GetMapping("/getInspectorHistory/{id}")
    public List<Inspect> getInspectHistoryByInspectorId(@PathVariable int id) {
        return inspectService.getInspectHistoryByInspectorId(id);
    }

    @GetMapping("/getInspectorUpComing/{id}")
    public List<Inspect> getUpComingInspectByInspectorId(@PathVariable int id) {
        return inspectService.getUpcomingInspectByInspectorId(id);
    }


}
