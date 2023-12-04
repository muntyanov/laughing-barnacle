package ru.tinkoff.seminars.homework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.seminars.homework.service.AnalyticService;

@RestController
public class AnalyticController {

	private AnalyticService analyticService;

	@Autowired
	public AnalyticController(AnalyticService analyticService) {
		this.analyticService = analyticService;
	}

	@RequestMapping("/see/{id}")
	public ResponseEntity<Void> see(@PathVariable("id") int itemId){
		analyticService.see(itemId);
		return ResponseEntity.ok().build();
	}
}
