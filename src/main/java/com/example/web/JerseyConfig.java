package com.example.web;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/jer")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig(){
        
		packages("com.example.web");
		
	}
	
}
