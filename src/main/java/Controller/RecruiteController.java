package Controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoRecruitment.ApplicationRepository;
import com.example.DemoRecruitment.DemoApplication;
import com.example.DemoRecruitment.DemoOffer;
import com.example.DemoRecruitment.RecruitmentRepository;

@RestController
@RequestMapping("/api")
public class RecruiteController {
	@Autowired
	RecruitmentRepository repository;
	
	@Autowired
	ApplicationRepository appRepository;
	
	@GetMapping("/Db")
	public List<DemoApplication> getOffer() {
		System.out.println("My DB Password is");
		ArrayList<DemoApplication> appList = new ArrayList<DemoApplication>();
		DemoOffer offer = new DemoOffer();
		offer.setJobTitle("Job1");
//		offer.setApplications(appList);
		offer.setStartDate(new Date());
		repository.save(offer);
		
		DemoApplication app1 = new DemoApplication();
		app1.setApplicationStatus("APPLIED");
		app1.setCandidateEmail("C1Email");
		app1.setText("resume1");
		app1.setRelatedOffer(offer);
		
		DemoApplication app2 = new DemoApplication();
		app2.setApplicationStatus("REJECTED");
		app2.setCandidateEmail("C2Email");
		app2.setText("resume2");
		app2.setRelatedOffer(offer);
		
		appRepository.save(app1);
		appRepository.save(app2);
		
		appList.add(app1);
		appList.add(app2);
		
		offer.setApplications(appList);
		repository.save(offer);
		
		return appRepository.findAll();
	}
	@PostMapping("/create-offer")// create the offer
	public DemoOffer createOffer(@RequestBody DemoOffer offer) {
		return repository.save(offer);
	}
	
	@GetMapping("/offerList")//returns the job list choose one to apply
	public List<String> offerList() {
		List<String> offerlist = new ArrayList<String>();
		List<DemoOffer> list =repository.findAll(); 
		for(DemoOffer d:list) {
			offerlist.add(d.getJobTitle());
		}
		return offerlist;
	}
	@GetMapping("/userOfferList")// list offers with all the applications 
	public List<DemoOffer> userOfferList() {
		
		return repository.findAll();
	}
	
	@GetMapping("/offerByJobTitle")// returns offer object by the job title provide as queryParam 
	public DemoOffer offerByJobTitle(@RequestParam(value = "title") String title) {
		
		return repository.findByJobTitle(title);
	}
	
	@PostMapping("/create-application") //provide the job title to apply for a specific job
	public DemoApplication createOffer(@RequestBody DemoApplication application,@RequestParam(value = "jobTitle") String title ) {
		DemoOffer offer = repository.findByJobTitle(title);
		ArrayList<DemoApplication> appList = new ArrayList<DemoApplication>();
		application.setRelatedOffer(offer);
		appRepository.save(application);
		appList.add(application);
		offer.setApplications(appList);
		repository.save(offer);
		return application;
	}
	
}
