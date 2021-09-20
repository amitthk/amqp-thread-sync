package com.boot.controller;

import com.boot.entity.TaskSingleton;
import com.boot.model.Blogpost;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/home")
public class HomeController {

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public CompletableFuture<Blogpost> home(@RequestParam(name = "name", required = false) String name) throws InterruptedException {
		if(name == null || name.isEmpty()){
			name = UUID.randomUUID().toString();
		}
		return findItem(name);
	}

	@RequestMapping(value = "status", method = RequestMethod.GET)
	public HashMap status()  {
		return TaskSingleton.getInstance().getTaskProgress();
	}

	@Async
	public CompletableFuture<Blogpost> findItem(String name) throws InterruptedException {
		logger.info("Looking up " + name);
		Blogpost results = new Blogpost();
		results.setId(200L);
		results.setName(name);
		results.setDescription("Test Async task description "+ name);
		Long timeout = 0L;
		while (timeout<= 15000*3600L)
		{
			TaskSingleton.getInstance().setTaskProgress(name,timeout);
			if(timeout>0) {
				Thread.sleep(timeout);
			}
			timeout+=3600;
		}
		return CompletableFuture.completedFuture(results);
	}


}
