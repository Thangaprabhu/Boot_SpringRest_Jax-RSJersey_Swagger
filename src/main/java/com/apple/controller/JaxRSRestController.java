package com.apple.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.apple.model.User;
import com.apple.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "Jax RS Users", description = "Does Crud Operations on User")
@Path("/jaxRsRest")
@Controller
public class JaxRSRestController {

	@Autowired
	UserService userService;

	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listAllUsers() {
		System.out.println("Fetching All Users");
		return userService.findAllUsers();
	}

	// ---Retrieve Single User-----
	@ApiOperation(value = "Gets User by passing Id", notes = "&lt;rdar://problem/18540335> #017 - Get Triggers [6]", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid filter criteria"),
			@ApiResponse(code = 404, message = "No Triggers found for this locale"),
			@ApiResponse(code = 400, message = "CASWS-TOP-003 : Invalid Symptom Category Id"),
			@ApiResponse(code = 400, message = "CASWS-TOP-004 : Invalid Symptom Id") })
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@ApiParam(name = "id", value = "id") @PathParam("id") long id) {
		System.out.println("Fetching User with id " + id);
		return userService.findById(id);
	}

	@ApiOperation(value = "sayHello", nickname = "sayHello")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GET
	@Path("hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() {
		return "Hello World from " + "Server";
	}

}
