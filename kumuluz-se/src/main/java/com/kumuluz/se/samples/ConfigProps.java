package com.kumuluz.se.samples;

import javax.enterprise.context.ApplicationScoped;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

@ApplicationScoped
@ConfigBundle("my-props")
public class ConfigProps {
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
