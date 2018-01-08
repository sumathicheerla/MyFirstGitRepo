package com.sumathi.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLogger {
final static Logger logger=Logger.getLogger(TestLogger.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
       logger.debug("this is debug");
       logger.info("this is info");
       logger.warn("this is warn");
       logger.error("this is error");
       logger.fatal("this is fatal");
      
	}
}
