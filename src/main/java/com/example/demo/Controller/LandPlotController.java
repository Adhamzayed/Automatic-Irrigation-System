package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.LandPlot;
import com.example.demo.Service.LandPlotService;

@RestController
@RequestMapping("/landPlot")
public class LandPlotController {
	@Autowired
	private LandPlotService landPlotService;
	
	@GetMapping("/count")
	public long countLandPlot() {
		return landPlotService.count();
	}
	
	//*************
	
    @PostMapping("")
    public ResponseEntity<LandPlot> createOrUpdateLandPlot(@RequestBody LandPlot landPlot) {
        return new ResponseEntity<>(landPlotService.createOrUpdateLandPlot(landPlot), HttpStatus.CREATED);
    }
	
    @GetMapping("/findAll")
    public List<LandPlot> findAllLandPlot() {
        return landPlotService.findAllLandPlot();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LandPlot>> findLandPlotById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(landPlotService.findLandPlotById(id));
    }

    @PutMapping
    public ResponseEntity<LandPlot> updateLandPlot(@RequestBody LandPlot landPlot) {
        LandPlot updatedLandPlot = landPlotService.createOrUpdateLandPlot(landPlot);
        return new ResponseEntity<>(updatedLandPlot, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLandPlot(@PathVariable(name = "id") long id) {

        landPlotService.deleteLandPlotById(id);
        return new ResponseEntity<>("Land Plot deleted Successfully", HttpStatus.OK);

    }

    //irrigate and update the land-plot's time slot

    @PutMapping("/{id}/irrigate")
    public ResponseEntity<LandPlot> irrigateLandPLot(@PathVariable(name = "id") long id){

        LandPlot irrigatedLandPlot = landPlotService.irrigateLandPlot(id);
        return new ResponseEntity<>(irrigatedLandPlot,HttpStatus.OK);

    }
    
    @PostMapping("/insert")
    public LandPlot insertlandPlot(@RequestBody LandPlot landPlot) {
    	
    	return landPlotService.createOrUpdateLandPlot(landPlot);
    }

}
