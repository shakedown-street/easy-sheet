package com.v2;

public class AppConfig {
	
	private enum Environment {
			DEV, PRODUCTION
	}
	
	public static final String NAME = "EasySheet";
	public static final int REVISION = 0;
	public static final Environment ENV = Environment.DEV;

}
