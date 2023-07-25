package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Crop;
import com.example.demo.Entity.LandPlot;
import com.example.demo.Repository.LandPlotRepository;

@Service
public class LandPlotService {

	@Autowired
	private LandPlotRepository landPlotRepository;
	@Autowired
	private SensorService sensorService;

	public long count() {
		return landPlotRepository.count();
	}

	public List<LandPlot> findAllLandPlot() {
		return landPlotRepository.findAll();
	}

	public Optional<LandPlot> findLandPlotById(Long id) {
		return landPlotRepository.findById(id);
	}

	public void deleteLandPlotById(Long id) {
		landPlotRepository.deleteById(id);
	}

	public LandPlot createOrUpdateLandPlot(LandPlot landPlot) {
		return landPlotRepository.save(landPlot);
	}

	private float predictWaterAmount(LandPlot landPlot, Crop crop) {
		float waterPerFeddan = crop.getWaterPerFeddan();
		waterPerFeddan = waterPerFeddan * landPlot.getAreaInFeddan();
		return waterPerFeddan;
	}

	private Long predictSlotTime(LandPlot landPlot, Crop crop) {

		Long timePerFeddan = (long) crop.getMinutesPerFeddan();
		timePerFeddan = timePerFeddan * landPlot.getAreaInFeddan();
		return timePerFeddan;
	}

	public LandPlot irrigateLandPlot(long id) {

		LandPlot land = landPlotRepository.findById(id).get();

		Crop crop = land.getCrop();

		float waterPerFeddan = predictWaterAmount(land, crop);

		long minutesPerFeddan = predictSlotTime(land, crop);

		sensorService.irrigateCallToSensor(land, waterPerFeddan);
		// Update the Land Plot with new Time Slot
		land.setTimeSlot(land.getTimeSlot().plusMinutes(minutesPerFeddan));

		return createOrUpdateLandPlot(land);
	}

}
