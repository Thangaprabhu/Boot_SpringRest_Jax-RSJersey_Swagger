package com.apple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.model.User;
import com.apple.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Users", description = "Does Crud Operations on User")
@RestController
public class UserRestController {

	@Autowired
	UserService userService;

	// Retrieve All Users---
	@RequestMapping(value = "/user", method = { RequestMethod.GET })
	public List<User> listAllUsers() {
		System.out.println("Fetching All Users");
		return userService.findAllUsers();
	}

	// ---Retrieve Single User-----
	@RequestMapping(value = "/user/{id}", method = { RequestMethod.GET })
	@ApiOperation(value = "Gets User by passing Id", notes = "&lt;rdar://problem/18540335> #017 - Get Triggers [6]", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid filter criteria"),
			@ApiResponse(code = 404, message = "No Triggers found for this locale"),
			@ApiResponse(code = 400, message = "CASWS-TOP-003 : Invalid Symptom Category Id"),
			@ApiResponse(code = 400, message = "CASWS-TOP-004 : Invalid Symptom Id") })
	public User getUser(@ApiParam(name = "id", value = "id") @PathVariable long id) {
		System.out.println("Fetching User with id " + id);
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "sayHello", nickname = "sayHello")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public String hello() {
		return "Hello World from " + "Server";
	}

}
