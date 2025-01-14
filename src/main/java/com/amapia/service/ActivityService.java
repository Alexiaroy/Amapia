package com.amapia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Activity;
import com.amapia.entity.Amap;

public interface ActivityService {

	List<Activity> findAll();
									// "Multipart file" added to handle the image
	Activity save(Activity activity, MultipartFile file) throws IOException; 

	Activity findById(Long id);
	
	void deleteById(Long id);
	
	List<Activity> findByProducerId(Long producer_id);
	
	String formatDuration(Activity activity); /*Calculate the duration between 2 times and convert it into min or hours*/
	 
	List<Activity> findAvailableActivities();
	
	List<Activity> getLastTwoActivitiesByAmap(Amap amap);
	
	List<Activity> getActivitiesByAmap(Amap amap);
			 			
}
