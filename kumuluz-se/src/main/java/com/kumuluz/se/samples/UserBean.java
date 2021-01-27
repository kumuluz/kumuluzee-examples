package com.kumuluz.se.samples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class UserBean {
	private static final Logger LOGGER = Logger.getLogger(UserBean.class.getCanonicalName());

	private final ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
	
	@Inject
	private ConfigProps properties;
	
	@PostConstruct
	public void afterConstruct() {
		//Your app has to continuously do stuff, otherwise Weld will terminate it
		exec.scheduleAtFixedRate(this::alive, 1, 1, TimeUnit.SECONDS);
	}
	
	public void onInit(@Observes @Initialized(ApplicationScoped.class) Object init) {
		LOGGER.info(properties.getProperty());
	}
	
	private void alive() {
		LOGGER.info("I'm alive!");
	}
}
