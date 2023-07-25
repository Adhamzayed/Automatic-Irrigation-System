package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.LandPlot;

@Repository
public interface LandPlotRepository extends JpaRepository<LandPlot,Long> {

//	LandPlot createorUpdateLandPlot(LandPlot landPlot);
//	LandPlot getLandPlotById(Long id);
//
////	    LandPlot updateLandPlot(LandPlot landPlot, int id);
//
//	public LandPlot irrigateLandPlot(Long id);
//
//	void deleteLandPlot(long id);
}
