package com.amapia.service.impl;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Activity;
import com.amapia.entity.Amap;
import com.amapia.repository.ActivityRepository;
import com.amapia.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	// Modifed part to handle the image
	@Override
	public Activity save(Activity activity, MultipartFile file) throws IOException {
		if (file != null && !file.isEmpty()) {
			activity.setImageData(file.getBytes());
			activity.setImageName(file.getOriginalFilename());
			activity.setImageType(file.getContentType());
		}
		return activityRepository.save(activity);
	}
	//

	@Override
	public Activity findById(Long id) {
		return activityRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		activityRepository.deleteById(id);

	}

	@Override
	public List<Activity> findByProducerId(Long producer_id) {
		return activityRepository.findByProducerId(producer_id);
	}

	
	/*Method to calculate the duration between the endTime and startTime
	 * and decompose the time into a userfriendly format in case it is longer than 1h
	 * 
	 */
	@Override
								//Added Activity and the getters to access attributes startTime and endTime from Activity entity
	public String formatDuration(Activity activity) {
		LocalTime startTime = activity.getStartTime(); 
		LocalTime endTime = activity.getEndTime();

		// If startTime and endTime found, do --> (endTime-startTime).toMinutes();
		if (startTime != null && endTime != null) {
			long durationMin = Duration.between(startTime, endTime).toMinutes();

			//if the found result  is inferior to 60 min, show the result in minutes
			if (durationMin < 60) {
				return durationMin + " min";
			
			/* else, if the found result is superior to 60 min, convert it into hours by decomposition :
			 * hours + "h" + remainingMinutes
			 */	
			}else {
				long hours = durationMin/60; // Conversion from min to hours (ex : 90/60 -> 1h)
				
				long remainingMinutes = durationMin % 60; // 90 % 60 = 30 (bc 90 = 1*60 + 30)
				
				// return will show : 1 "h" + 30 = 1h30. If no remainingMin it shows nothing
				return hours +"h"+ (remainingMinutes > 0 ? remainingMinutes : "");
			}
		}
			return null;
		}

	@Override
	public List<Activity> findAvailableActivities() {
		return activityRepository.findByIsActiveTrue();
	}
	
	@Override
	public List<Activity> getActivitiesByAmap(Amap amap) {
		return activityRepository.findActivityByAmap(amap);
	}

	@Override
	public List<Activity> getLastTwoActivitiesByAmap(Amap amap) {
		List<Activity> allActivities = activityRepository.findTop2ByAmapOrderByIdDesc(amap);
		return allActivities.stream().limit(2).collect(Collectors.toList());
	}

	
	
	

}
