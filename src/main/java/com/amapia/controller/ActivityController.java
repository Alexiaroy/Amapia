package com.amapia.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Activity;
import com.amapia.entity.Member;
import com.amapia.entity.MemberType;
import com.amapia.entity.Producer;
import com.amapia.entity.Volunteer;
import com.amapia.service.ActivityService;
import com.amapia.service.ProducerService;

/**
 * Controller that handles the creation, update and desactivation of an activity
 * 
 * TODO : adjust : delete and desactivate activity only if no members are
 * registered for it.
 * 
 * 
 * @author Siham
 *
 */
@Controller
@RequestMapping("/activities")
public class ActivityController {

	@Autowired
	private ProducerService producerService;

	@Autowired
	private ActivityService activityService;

	/* Redirects the user to the home page */
	@GetMapping
	public String redirectToHome() {
		return "redirect:/home";
	}

	/*
	 * Handles a GET request to display the activity creation form. The producer's
	 * ID is retrieved from the session, and an empty activity object is prepared
	 * for the form binding.
	 */
	@GetMapping("/createActivity")
	public String creationFormActivity(HttpSession session, Model model) {
		Member member = (Member) session.getAttribute("member");
		if (member != null && member.getProducer() != null) {
			Producer producer = member.getProducer();
			model.addAttribute("producer", producer);
			model.addAttribute("activity", new Activity()); // Empty activity for the form
			return "Activity/creationForm"; // Redirection to the creation form
		}
		return "error/404";
	}

	/**
	 * Aim : Creates an activity with the provided form data.
	 * 
	 * Note : - The date format is adapted using @DateTimeFormat(pattern =
	 * "yyyy-MM-dd"). - An image file is mandatory for creating a new activity.
	 * 
	 * How : 1) Retrieve the producer based on the ID. 2) Creates the activity's
	 * fields with the new data from the form. 3) Save the changes to the database,
	 * handling the image file.
	 * 
	 * Exception : Throws IOException if the file cannot be saved properly or if the
	 * file is missing.
	 */
	@PostMapping("/createActivity")
	public String saveActivity(@RequestParam Long producer_id, @RequestParam String activityName,
			@RequestParam String activityDescription,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime startTime,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime endTime,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTime, @RequestParam int availableSpots,
			@RequestParam boolean isActive, @RequestParam String location, @RequestParam double price,
			@RequestParam("imageFile") MultipartFile file, Model model) throws IOException { // Adding the multipart
																								// file

		// 1) Find the producer based on it's registered ID
		Producer producer = producerService.findById(producer_id);

		// 2) Creates a new activity with the provided form data
		Activity activity = new Activity();

		activity.setActivityName(activityName);
		activity.setActivityDescription(activityDescription);
		activity.setDateTime(dateTime);
		activity.setStartTime(startTime);
		activity.setEndTime(endTime);
		activity.setLocation(location);
		activity.setAvailableSpots(availableSpots);
		activity.setRemainingSpots(availableSpots); // Initialize the remaining spots with availableSpots
		activity.setRegisteredMembers(0); // Initialize the registered members to 0
		activity.setProducer(producer);
		activity.setActive(false);
		activity.setPrice(price);
		
		//Temporary initialization for testing
	//    activity.setRegisteredMembers(1); // simulation of a registered member
	 //   activity.setRemainingSpots(availableSpots - 1);

		/*
		 * Calculate the duration in minutes between two times (e.g., 15:00 - 16:00) and
		 * cast the result into an integer to ensure precision in the database
		 */
		int durationMin = (int) Duration.between(startTime, endTime).toMinutes();
		activity.setDuration(durationMin);

		// 3) Saving into DB
		activityService.save(activity, file); // Adding the "file" to fit the save method signature

		return "Activity/confirmation";
	}

	
	/*
	 * Handles a GET request to display the list of all registered activities for a
	 * specific producer.
	 * 
	 * How : 1) Retrieve the logged-in member from the session 2) Check if the
	 * member is logged in and associated with a producer 3) Fetch activities
	 * related to the producer 4) Format the duration for each activity before
	 * adding it to the model 5) Display the activities list view or redirect to an
	 * error page if necessary
	 */
	@GetMapping("/activitiesList")
	public String ShowActivitiesByProducer(HttpSession session, Model model) {
		// 1) Retrieve the logged-in member from the session
		Member member = (Member) session.getAttribute("member");

		// 2) Check if the member is logged in and associated with a producer
		if (member != null && member.getProducer() != null) {
			Producer producer = member.getProducer(); // One-to-one relationship from member
			Long producer_id = producer.getProducer_id();

			// 3) Fetch activities related to the producer
			List<Activity> activities = activityService.findByProducerId(producer_id);

			// 4) Format the duration for each activity before adding it to the model
			for (Activity activity : activities) {
				String formattedDuration = activityService.formatDuration(activity); // Calls the format method
				activity.setFormattedDuration(formattedDuration); // Store the formated information in the temporary
																	// attribute
			}
			// 5) Add activities to the model for the view
			model.addAttribute("activities", activities);

			return "Activity/activitiesByProducer";
		}
		// Redirect to an error page if not logged in or no producer found
		return "error/404"; // If the user isn't logged in or isn't a producer
	}

	/*
	 * Handles a GET request to display the update activity form for a specific
	 * producer and activity.
	 * 
	 * How : 1) Retrieve the producer using the provided producer ID 2) Retrieve the
	 * activity using the provided activity ID 3) Add the producer and activity
	 * objects to the model to pre-fill the form 4) Return the view name for the
	 * update activity form
	 */
	@GetMapping("/updateActivity/{producer_id}/{activity_id}")
	public String showUpdateForm(@PathVariable Long producer_id, @PathVariable Long activity_id, Model model) {

		// 1) Retrieve the producer using the provided producer ID
		Producer producer = producerService.findById(producer_id);

		// 2) Retrieve the activity using the provided activity ID
		Activity activity = activityService.findById(activity_id);

		// 3) Add the producer and activity objects to the model to pre-fill the form
		model.addAttribute("producer", producer);
		model.addAttribute("activity", activity);

		// 4) Return the view name for the update activity form
		return "Activity/UpdateActivity";
	}

	/**
	 * Aim : Updates an existing activity with the provided form data.
	 * 
	 * Notes: - Dates and times are formatted using @DateTimeFormat. - Allows
	 * updating optional fields like the image while retaining existing data if no
	 * new file is provided.
	 * 
	 * How : 1) Retrieve the activity and producer based on their IDs. 2) Update the
	 * activity's fields with the new data from the form. 3) Save the changes to the
	 * database, handling the image file if provided.
	 */
	@PostMapping("/updateActivity")
	public String updateActivity(@RequestParam Long producer_id, @RequestParam Long activity_id,
			@RequestParam String activityName, @RequestParam String activityDescription,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTime,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime startTime, @RequestParam double price,
			@RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime endTime, @RequestParam int availableSpots,
			@RequestParam String location, @RequestParam("imageFile") MultipartFile file, // Adding the multipart file
			HttpSession session, Model model) throws IOException {

		// 1) Retrieve the activity and producer based on their IDs
		Producer producer = producerService.findById(producer_id);
		Activity activity = activityService.findById(activity_id);
		Member member = (Member) session.getAttribute("member");

		model.addAttribute("producer", producer);
		model.addAttribute("activity", activity);
		
		

		// 2) Update activity fields
		activity.setActivityName(activityName);
		activity.setActivityDescription(activityDescription);
		activity.setDateTime(dateTime);
		activity.setStartTime(startTime);
		activity.setEndTime(endTime);
		activity.setLocation(location);
		activity.setAvailableSpots(availableSpots);
		activity.setProducer(producer);
		activity.setPrice(price);

		// Calculate and update duration in minutes
		int durationMin = (int) Duration.between(startTime, endTime).toMinutes();
		activity.setDuration(durationMin);

		/*
		 * 3) Check if an image is uploaded with the form: - If an image is provided,
		 * save it along with the activity. (1) - If no image is provided (null or
		 * empty), save the activity while keeping the existing image. (2) This ensures
		 * that the user is not forced to upload a new image every time they update the
		 * activity.
		 */

		if (file != null && !file.isEmpty()) {
			activityService.save(activity, file); /* (1) Saves the activity with the new image */
		} else {
			activityService.save(activity, null); /* (2) Save the activity without changing the image */
		}

		// 4) Redirect based on the member type
		return member.getMemberType() == MemberType.VOLUNTEER ? "redirect:/activities/allActivities"
				: "redirect:/activities/activitiesList";
	}

	// Method to retrieve the image associated with an activity by its ID
	@GetMapping("/activityImage/{activity_id}")
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@PathVariable Long activity_id) {

		// Fetch the activity by its ID
		Activity activity = activityService.findById(activity_id);

		// Verify if the activity exists and contains image data
		if (activity != null && activity.getImageData() != null) {
			HttpHeaders headers = new HttpHeaders(); // Initialize headers for the response

			// Verify the image type and set the corresponding content type in headers
			String fileType = activity.getImageType().toLowerCase();
			if (fileType.equals("png")) {
				headers.setContentType(MediaType.IMAGE_PNG);
			} else {
				headers.setContentType(MediaType.IMAGE_JPEG);
			}

			// Return the image data along with the appropriate headers
			return new ResponseEntity<>(activity.getImageData(), headers, HttpStatus.OK);
		}

		// Return a 404 status if no image is found for the given activity
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@PostMapping("/registerToActivity/{activityId}")
	public String registerToActivity(@PathVariable Long activity_id, HttpSession session, Model model) {

		Member member = (Member) session.getAttribute("member");
		if (member != null && member.getMemberType() == MemberType.INDIVIDUAL) {

			Activity activity = activityService.findById(activity_id);

			if (activity.getRemainingSpots() == 0) {
				model.addAttribute("errorMessage", "Désolé, l'activité est complète !");
				return "error";
			}

			int remainingSpots = activity.getRemainingSpots() - 1;
			int registeredMembers = activity.getRegisteredMembers() + 1;

			activity.setRemainingSpots(remainingSpots);
			activity.setRegisteredMembers(registeredMembers);

			try {
				activityService.save(activity, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "Activity/confirmation";
		}
		return null;
	}

	// Delete method (even from DB) [TEMPORARY. will be removed later alongside with the delete button in the view]
	@GetMapping("/deleteActivity/{producer_id}/{activity_id}")
	public String deleteActivity(@PathVariable Long producer_id, @PathVariable Long activity_id, HttpSession session) {

		Member member = (Member) session.getAttribute("member");
		if (member != null && member.getProducer() != null
				&& member.getProducer().getProducer_id().equals(producer_id)) {

			activityService.deleteById(activity_id);

			return "redirect:/activities/activitiesList";
		}
		return null;
	}

	// Activation and desactivation methods
	@PostMapping("/activateActivity/{producer_id}/{activity_id}")
	public String activateActivity(@PathVariable Long producer_id, @PathVariable Long activity_id,
			HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if (member != null && member.getProducer() != null
				&& member.getProducer().getProducer_id().equals(producer_id)) {
			Activity activity = activityService.findById(activity_id);
			activity.setActive(true);

			try {
				activityService.save(activity, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "redirect:/activities/activitiesList";
		}
		return null;
	}

	@PostMapping("/desactivateActivity/{producer_id}/{activity_id}")
	public String desactivateActivity(@PathVariable Long producer_id, @PathVariable Long activity_id,
			HttpSession session, Model model) {
		Member member = (Member) session.getAttribute("member");
		if (member != null && member.getProducer() != null
				&& member.getProducer().getProducer_id().equals(producer_id)) {
			 
			Activity activity = activityService.findById(activity_id);

			//Verification if there are registeredMembers
			 if (activity.getRegisteredMembers() != 0) {
		            model.addAttribute("errorMessage", "Impossible de désactiver cette activité, des membres y sont inscrits !");
		            return "redirect:/activities/activitiesList"; 
		        }
			 
			// Else, desactivate
			activity.setActive(false);
			try {
				activityService.save(activity, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/activities/activitiesList";
		}
		return null;
	}
}
