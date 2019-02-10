package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service1 {
	@Autowired
	private RestTemplate restTemp;

	@GetMapping("/one")
	public String geMessage() throws InterruptedException, ExecutionException {

		Callable<String> callableTask1 = () -> {
			return restTemp.getForObject("http://localhost:8080/two", String.class);
		};
		Callable<String> callableTask2 = () -> {
			return restTemp.getForObject("http://localhost:8080/three", String.class);
		};
		Callable<String> callableTask3 = () -> {
			return restTemp.getForObject("http://localhost:8080/four", String.class);
		};
		Callable<String> callableTask4 = () -> {
			return restTemp.getForObject("http://localhost:8080/five", String.class);
		};

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask1);
		callableTasks.add(callableTask2);
		callableTasks.add(callableTask3);
		callableTasks.add(callableTask4);

		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<String>> results = executor.invokeAll(callableTasks);

		for (Future<String> response : results) {
			System.out.println("" + response.get());
		}
		
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		List<Future<String>> result = pool.invokeAll(callableTasks);
		for(Future<String> response : result){
		    System.out.println(response.get());
		}
		return "Service1" + result;
	}

}
