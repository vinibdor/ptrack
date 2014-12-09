package br.org.vinicius.jsf.ptrack.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Initializer implements ServletContextListener {

	public Initializer() {
	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		Utils.log(servletContext, "Initializing ProjectTrack...");
		servletContext.setAttribute(Constants.PROJECT_COORDINATOR_KEY,
				new MemoryProjectCoordinator());
		servletContext.setAttribute(Constants.STATUS_COORDINATOR_KEY,
				new MemoryStatusCoordinator());
		servletContext.setAttribute(Constants.USER_COORDINATOR_KEY,
				new MemoryUserCoordinator());
		Utils.log(servletContext, "Initialization complete...");
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
