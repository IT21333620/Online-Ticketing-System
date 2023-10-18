package com.example.onlineticketingsystem.service;

import com.example.onlineticketingsystem.DTO.InspectDTO;
import com.example.onlineticketingsystem.entity.Inspect;
import com.example.onlineticketingsystem.repo.InspectRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class InspectService {

    @Autowired
    private InspectRepo inspectRepo;
    @Autowired
    private ModelMapper modelMapper;

    public InspectDTO saveInspect(InspectDTO inspectDTO){
        inspectRepo.save(modelMapper.map(inspectDTO, Inspect.class));
        return inspectDTO;
    }

    public List<InspectDTO> getAllInspects(){
        List<Inspect> inspectList= inspectRepo.findAll();
        return modelMapper.map(inspectList, new TypeToken<List<Inspect>>(){}.getType());
    }

    public boolean delete(InspectDTO inspectDTO){
        inspectRepo.delete(modelMapper.map(inspectDTO, Inspect.class));
        return true;
    }

    public List<Inspect> getInspectsByInspectorId(int inspectorId) {
        return inspectRepo.findByInspectorId(inspectorId);
    }

    public InspectDTO updateInspect(InspectDTO inspectDTO){
        inspectRepo.save(modelMapper.map(inspectDTO,Inspect.class));
        return inspectDTO;
    }

    public int fraudCount() {
        int sum = 0;
        List<Inspect> inspectList = inspectRepo.findAll();
        for (Inspect inspect : inspectList) {
            sum += inspect.getNoFraudDetected();
        }
        return sum;
    }

    public Map<Integer, Integer> fraudByRoute() {
        Map<Integer, Integer> fraudCountByRouteId = new HashMap<>();

        List<Inspect> inspectList = inspectRepo.findAll();

        for (Inspect inspect : inspectList) {
            int routeId = inspect.getRouteId();
            int currentCount = fraudCountByRouteId.getOrDefault(routeId, 0);
            int newCount = currentCount + inspect.getNoFraudDetected();
            fraudCountByRouteId.put(routeId, newCount);
        }

        return fraudCountByRouteId;
    }

    public Map<Integer, Long> getCountOfInspectorIdByRouteToday() {
        Map<Integer, Long> countByRoute = new HashMap<>();

        List<Inspect> inspectList = inspectRepo.findByInspectDate(Date.valueOf(LocalDate.now()));

        for (Inspect inspect : inspectList) {
            int routeId = inspect.getRouteId();
            countByRoute.merge(routeId, 1L, Long::sum);
        }

        return countByRoute;
    }
    public List<Inspect> getInspectHistoryByInspectorId(int inspectorId) {
        LocalDate firstDayOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        Date sqlFirstDayOfYear = Date.valueOf(firstDayOfYear);
        Date sqlNow = Date.valueOf(LocalDate.now());

        return inspectRepo.findByInspectorIdAndInspectDateBetween(inspectorId, sqlFirstDayOfYear, sqlNow);
    }

    public List<Inspect> getUpcomingInspectByInspectorId(int id) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate endOfYear = LocalDate.of(LocalDate.now().getYear(), 12, 31);

        Date sqlTomorrow = Date.valueOf(tomorrow);
        Date sqlEndOfYear = Date.valueOf(endOfYear);

        return inspectRepo.findByInspectorIdAndInspectDateBetween(id, sqlTomorrow, sqlEndOfYear);
    }


}
