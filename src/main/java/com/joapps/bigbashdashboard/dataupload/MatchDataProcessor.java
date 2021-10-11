package com.joapps.bigbashdashboard.dataupload;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import model.MatchData;

public class MatchDataProcessor implements ItemProcessor<MatchDataInputEntity, MatchData> {

	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	@Override
	public MatchData process(final MatchDataInputEntity data) throws Exception {
		
		MatchData finalDataObj = new MatchData(); 
		finalDataObj.setId(Long.parseLong(data.getId()));
		finalDataObj.setCity(data.getCity());
		System.out.println(data.getDate());
		finalDataObj.setDate(LocalDate.parse(data.getDate()));
		finalDataObj.setPlayerOfMatch(data.getPlayerOfMatch());
		finalDataObj.setVenue(data.getVenue());
		String firstInnings, secondInnings;	
		if(Objects.nonNull(data.getTossDecision()) && "bat".equals(data.getTossDecision())){
			if(data.getTossWinner().equals(data.getTeam1())) {
				firstInnings = data.getTeam1();
				secondInnings = data.getTeam2();
			}
			else {
				firstInnings = data.getTeam2();
				secondInnings = data.getTeam1();			
			}
		}else {
			if(data.getTossWinner().equals(data.getTeam1())) {
				firstInnings = data.getTeam2();
				secondInnings = data.getTeam1();
			}
			else {
				firstInnings = data.getTeam1();
				secondInnings = data.getTeam2();			
			}
		}
		finalDataObj.setTeam1(firstInnings);
		finalDataObj.setTeam2(secondInnings);
		finalDataObj.setTossWinner(data.getTossWinner());
		finalDataObj.setTossDecision(data.getTossDecision());
		finalDataObj.setWinner(data.getWinner());
		finalDataObj.setResult(data.getResult());
		finalDataObj.setResultMargin(data.getResultMargin());
		finalDataObj.setEliminator(data.getEliminator());
		finalDataObj.setUmpire1(data.getUmpire1());
		finalDataObj.setUmpire2(data.getUmpire2());
		log.info("Converting (" + data + ") into (" + finalDataObj + ")");
		return finalDataObj;
	}

}
