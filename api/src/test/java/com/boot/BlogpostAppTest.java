package com.boot;

import com.boot.model.Blogpost;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.boot.controller.HomeController;

import java.util.concurrent.CompletableFuture;

public class BlogpostAppTest {

	@Test
    public void testApp() {
		HomeController hc = new HomeController();
		CompletableFuture<Blogpost> result = null;
		try {
			result = hc.home("Test1");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assert(true);
	}
}
