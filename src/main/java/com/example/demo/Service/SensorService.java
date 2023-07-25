package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.Client.SensorClient;
import com.example.demo.Entity.LandPlot;
import com.example.demo.Exception.SensorNotFoundException;

@Service
public class SensorService {
//	@Autowired
//	private CropRepository cropRepository;
//	@Autowired
//	private LandPlotRepository landPlotRepository;
	private static int counter = 0;
	private SensorClient sensorClient = new SensorClient();

	private void irrigate(LandPlot landPlotRetrieved, float waterPerFeddan) {
		sensorClient.irrigate(landPlotRetrieved.getxCoordinate(), landPlotRetrieved.getYCoordinate(),
				landPlotRetrieved.getAreaInFeddan(), waterPerFeddan);
		counter = 0;
	}

	/**
	 * Calls the sensor simulation and sends a landplot, recieves whether the
	 * request has been sent and irrigation has been performed successfully or not
	 * if request fails, performs retry pattern
	 *
	 * @param landPlotRetrieved,waterPerFeddan
	 * @return void
	 */

	public void irrigateCallToSensor(LandPlot landPlotRetrieved, float waterPerFeddan) {
		try {
			irrigate(landPlotRetrieved, waterPerFeddan);
			System.out.println("Irrigation Performed");
			// it should call the landplotservice to do the update part?
			// now since the irrigation is performed
			// the new timeslot of the landplot should be ((predictedTimeSlot +
			// landplot.timeslot)%24 (24 hours time format (12 AM == 0.0))

		} catch (SensorNotFoundException e) {

			if (counter < 3) {
				System.out.println("Irrigation call failed, attempt number: " + counter + ". Retry!");
				counter++;
				irrigateCallToSensor(landPlotRetrieved, waterPerFeddan); // it is calling irrigate here in the catch
																			// block, it should call
																			// irrigateCallToSensor

			} else {
				System.out.println("Number of attempts exceeded limit, Sensor is out of service!!");
				throw e;
			}
		}

	}
}
