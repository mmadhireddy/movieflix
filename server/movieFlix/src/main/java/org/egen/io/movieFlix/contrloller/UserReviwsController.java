package org.egen.io.movieFlix.contrloller;

import java.util.List;

import org.egen.io.movieFlix.UserReviewsPK;
import org.egen.io.movieFlix.entity.UserReviews;
import org.egen.io.movieFlix.service.UserReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="userreviews",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserReviwsController {
	@Autowired
	private UserReviewsService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<UserReviews> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReviews findOne(@RequestBody UserReviewsPK urwPK){
		return service.findOne(urwPK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="{imdbd}")
	public List<UserReviews> findMovieReviews(String imdbid){
		return service.findMovieReviews(imdbid);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReviews create(@RequestBody UserReviews urw) {
		return service.create(urw);
	}
	 
	@RequestMapping(method = RequestMethod.PUT,value="{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReviews update(@PathVariable("id") String id,@RequestBody UserReviews urw) {
		return service.update(id, urw);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@RequestBody UserReviewsPK urw_pk) {
		 service.delete(urw_pk);
	}
}
