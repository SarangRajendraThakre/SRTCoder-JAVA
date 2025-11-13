package com.srt.controller;

import com.srt.MvcWeb4Application;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    private final MvcWeb4Application mvcWeb4Application;

    HelloController(MvcWeb4Application mvcWeb4Application) {
        this.mvcWeb4Application = mvcWeb4Application;
    }

	//REST SERVICE : respresentational state transfer
	
	
	
	// by default it is GET method 
	@ResponseBody
	@RequestMapping(path = "/data")
	public String getData()
	{
		return "I am sarang thakre from wardha and this is /data api end point";
	}
	
	// Externally giving the MEthod type 
	@ResponseBody
	@RequestMapping(path = "/info" , method = RequestMethod.GET)
	public String getInfo()
	{
		return "I am sarang thakre from wardha and this is /info api end point";
	}
	
	
//  error for this method because end point is already defined
	
//	@ResponseBody
//	@RequestMapping(path = "/info" , method = RequestMethod.GET)
//	public String createInfo()
//	{
//		return "I am sarang thakre from wardha and this is /info api end point";
//	}
	
	
//  error for this  end point not come  , inspite of having the same end point 
//	two times /info , because i am having  the different RequestMethod this time.
	
	@ResponseBody
	@RequestMapping(path = "/info" , method = RequestMethod.POST)
	public String createInfo1() 
	{
		return "Data received /info";
	}
	
	// you can use the path or value 
	@ResponseBody
	@RequestMapping( value = "/contact" , method = {RequestMethod.GET , RequestMethod.POST})
	public String getContact() {
		return "Contact data received ";
	}
	
//	ShortHand/ShortCut Mapping Annotations of @RequestMapping:
//		------------------------------------------------------
//		=> Whenever an endpoint supporting only one HTTP method as per Requirement, then in
//		such scenarios we may use ShortHand/Shortcut Annotations in place of @RequestaMapping.
//
//		=> Spring Provide set of ShortHand/Shortcut Annotations which are specific to HTTP
//		method. as in below mapping 
	
////	HTTP Method	Shortcut Annotation	Equivalent @RequestMapping
////	GET	    @GetMapping  	@RequestMapping(method = RequestMethod.GET)
////	POST	@PostMapping	@RequestMapping(method = RequestMethod.POST)
////	PUT	    @PutMapping	    @RequestMapping(method = RequestMethod.PUT)
////	DELETE	@DeleteMapping	@RequestMapping(method = RequestMethod.DELETE)
	

//	@RequestMapping( value = "/address" , method = RequestMethod.GET )
	//	@ResponseBody if you keep comminting the error will come , 
	@ResponseBody
	@GetMapping("/address")
	public String getAddress() {
		return " address data received ";
	}
	
//	can we impl above annotations @GetMapping for below scenario : No
//	@RequestMapping(path="/contact", method = {RequestMethod.GET, RequestMethod.PUT})

	
// you normally format the @ResponseBody annoation , for that @RestController
	
	@ResponseBody
	@PutMapping("/address")
	public String updateInfo() {
		return "updated successully ";
	}
	
	@ResponseBody
	@DeleteMapping("/address")
	public String deleteInfo() {
		return "deleted successully ";
	}
	
	@ResponseBody
	@PostMapping("/address")
	public String createInfo() {
		return "created successully ";
	}
	@ResponseBody
	@PatchMapping("/address")
	public String patchInfo() {
		return "created successully ";
	}
	
	

	
	
	
	
	
	
}
