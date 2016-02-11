package com.webservices.utils;


public class Status
{
	public static final int OK = 200;
	public static final int NO_PRIVILEGE = 10001;
	public static final int EMAIL_IN_USE = 10002;
	public static final int NO_PASSWORD_MATCH = 10003;
	public static final int NO_USER = 10004;
	public static final int ACCOUNT_NOT_ACTIVATED = 10005;
	public static final int ACCESSTOKEN_INVALID = 10006;
	public static final int NOT_ENOUGH_PRIVILEGE = 10007;
	public static final int NO_USERIMAGE = 10008;
	public static final int INVALID_EMAIL = 10009;
	
	public static final int NO_SERVICE = 20001;
	public static final int NO_SITE = 20002;
	public static final int NO_FLOOR = 20003;
	public static final int NO_IMAGE = 20004;
	public static final int NO_DEVELOPER = 20005;
	public static final int NO_MANUFACTURER = 20006;
	public static final int SERVICENAME_IN_USE = 20007;
	public static final int NO_FLOORPLAN = 20008;
	public static final int NO_BEACON = 30001;
	public static final int NO_ACTION = 30002;
	public static final int NO_BEACON_PROFILE = 30003;
	public static final int NO_BEACON_MANUFACTURER = 30004;
	public static final int NO_APPS = 30005;
	public static final int UNKNOWN_ALERTTYPE = 30006;
	public static final int NO_NEW_FIRMWARE = 30007;
	public static final int NO_PURCHASEORDER = 40001;
	public static final int DATABASE_ERROR = 50001;
	
	public static final int INVALID_URL  = 60001;
	
	// added for log api
	public static final int INVALID_LOG_REQUEST = 70001;

	private int code = OK;

	public Status(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		switch (code)
		{
			case OK:
				return 200;
			case NO_PRIVILEGE:
				return 10001;
			case EMAIL_IN_USE:
				return 10002;
			case NO_PASSWORD_MATCH:
				return 10003;
			case NO_USER:
				return 10004;
			case ACCOUNT_NOT_ACTIVATED:
				return 10005;
			case ACCESSTOKEN_INVALID:
				return 10006;
			case NOT_ENOUGH_PRIVILEGE:
				return 10007;
			case NO_USERIMAGE:
				return 10008;
			case INVALID_EMAIL:
				return 10009;
			case NO_SERVICE:
				return 20001;
			case NO_SITE:
				return 20002;
			case NO_FLOOR:
				return 20003;
			case NO_IMAGE:
				return 20004;
			case NO_DEVELOPER:
				return 20005;
			case NO_MANUFACTURER:
				return 20006;
			case SERVICENAME_IN_USE:
				return 20007;
			case NO_FLOORPLAN:
				return 20008;
			case NO_BEACON:
				return 30001;
			case NO_ACTION:
				return 30002;
			case NO_BEACON_PROFILE:
				return 30003;
			case NO_BEACON_MANUFACTURER:
				return 30004;
			case NO_APPS:
				return 30005;
			case UNKNOWN_ALERTTYPE:
				return 30006;
			case NO_NEW_FIRMWARE:
				return 30007;
			case NO_PURCHASEORDER:
				return 40001;
			case DATABASE_ERROR:
				return 50001;
			case INVALID_URL:
				return 60001;
			case INVALID_LOG_REQUEST:
				return 70001;
		}
		return -1;
	}

	public String getMessage()
	{
		switch (code)
		{
			case OK:
				return "OK";
			case NO_PRIVILEGE:
				return "Privilege level not found";
			case EMAIL_IN_USE:
				return "Email address is already in use";
			case NO_PASSWORD_MATCH:
				return "Entered password does not matched with database";
			case NO_USER:
				return "No user found for this email address";
			case ACCOUNT_NOT_ACTIVATED:
				return "Account is not activated";
			case ACCESSTOKEN_INVALID:
				return "Accesstoken is invalid";
			case NOT_ENOUGH_PRIVILEGE:
				return "User has not required privilege level";
			case NO_USERIMAGE:
				return "User has no image";
			case NO_SERVICE:
				return "No service found for serviceID";
			case NO_SITE:
				return "No site found for siteID";
			case NO_FLOOR:
				return "No floor found for floorID";
			case NO_IMAGE:
				return "No image found for imageID";
			case NO_DEVELOPER:
				return "No developer found for developerID";
			case NO_MANUFACTURER:
				return "No beacon manufacturer found for manufacturerID";
			case SERVICENAME_IN_USE:
				return "The service name is already in use";
			case NO_FLOORPLAN:
				return "No floorplan uploaded for floor";
			case NO_BEACON:
				return "No beacon found for beaconID";
			case NO_ACTION:
				return "No action found";
			case NO_BEACON_PROFILE:
				return "No beacon profile found for beacon";
			case NO_BEACON_MANUFACTURER:
				return "No beacon manufacturer found for beacon";
			case NO_APPS:
				return "No application found";
			case UNKNOWN_ALERTTYPE:
				return "Unknown alert type";
			case NO_NEW_FIRMWARE:
				return "No new firmware found";
			case NO_PURCHASEORDER:
				return "No purchase order found for batchID";
			case DATABASE_ERROR:
				return "General database error";
			case INVALID_URL:
				return "Invalid URL";
			case INVALID_LOG_REQUEST:
				return "Invalid Log Request";
			case INVALID_EMAIL:
				return "Invalid Email Adress";
		}
		return "UNKNOWN ERROR";
	}

	public static String getMessage(int code)
	{
		switch (code)
		{
			case OK:
				return "OK";
			case NO_PRIVILEGE:
				return "Privilege level not found";
			case EMAIL_IN_USE:
				return "Email address is already in use";
			case NO_PASSWORD_MATCH:
				return "Entered password does not matched with database";
			case NO_USER:
				return "No user found for this email address";
			case ACCOUNT_NOT_ACTIVATED:
				return "Account is not activated";
			case ACCESSTOKEN_INVALID:
				return "Accesstoken is invalid";
			case NOT_ENOUGH_PRIVILEGE:
				return "User has not required privilege level";
			case NO_USERIMAGE:
				return "User has no image";
			case NO_SERVICE:
				return "No service found for serviceID";
			case NO_SITE:
				return "No site found for siteID";
			case NO_FLOOR:
				return "No floor found for floorID";
			case NO_IMAGE:
				return "No image found for imageID";
			case NO_DEVELOPER:
				return "No developer found for developerID";
			case NO_MANUFACTURER:
				return "No beacon manufacturer found for manufacturerID";
			case SERVICENAME_IN_USE:
				return "The service name is already in use";
			case NO_FLOORPLAN:
				return "No floorplan uploaded for floor";
			case NO_BEACON:
				return "No beacon found for beaconID";
			case NO_ACTION:
				return "No action found";
			case NO_BEACON_PROFILE:
				return "No beacon profile found for beacon";
			case NO_BEACON_MANUFACTURER:
				return "No beacon manufacturer found for beacon";
			case NO_APPS:
				return "No application found";
			case UNKNOWN_ALERTTYPE:
				return "Unknown alert type";
			case NO_NEW_FIRMWARE:
				return "No new firmware found";
			case NO_PURCHASEORDER:
				return "No purchase order found for batchID";
			case DATABASE_ERROR:
				return "General database error";
		}
		return "UNKNOWN ERROR";
	}

	public String toString()
	{
		switch (code)
		{
			case OK:
				return "Code=200, Message=OK";
			case NO_PRIVILEGE:
				return "Code=10001, Message=Privilege level not found";
			case EMAIL_IN_USE:
				return "Code=10002, Message=Email address is already in use";
			case NO_PASSWORD_MATCH:
				return "Code=10003, Message=Entered password does not matched with database";
			case NO_USER:
				return "Code=10004, Message=No user found for this email address";
			case ACCOUNT_NOT_ACTIVATED:
				return "Code=10005, Message=Account is not activated";
			case ACCESSTOKEN_INVALID:
				return "Code=10006, Message=Accesstoken is invalid";
			case NOT_ENOUGH_PRIVILEGE:
				return "Code=10007, Message=User has not required privilege level";
			case NO_USERIMAGE:
				return "Code=10008, Message=User has no image";
			case NO_SERVICE:
				return "Code=20001, Message=No service found for serviceID";
			case NO_SITE:
				return "Code=20002, Message=No site found for siteID";
			case NO_FLOOR:
				return "Code=20003, MessageNo floor found for floorID";
			case NO_IMAGE:
				return "Code=20004, Message=No image found for imageID";
			case NO_DEVELOPER:
				return "Code=20005, Message=No developer found for developerID";
			case NO_MANUFACTURER:
				return "Code=20006, Message=No beacon manufacturer found for manufacturerID";
			case SERVICENAME_IN_USE:
				return "Code=20007, Message=The service name is already in use";
			case NO_FLOORPLAN:
				return "Code=20008, Message=No floorplan uploaded for floor";
			case NO_BEACON:
				return "Code=30001, Message=No beacon found for beaconID";
			case NO_ACTION:
				return "Code=30002, Message=No action found";
			case NO_BEACON_PROFILE:
				return "Code=30003, Message=No beacon profile found for beacon";
			case NO_BEACON_MANUFACTURER:
				return "Code=30004, Message=No beacon manufacturer found for beacon";
			case NO_APPS:
				return "Code=30005, Message=No application found";
			case UNKNOWN_ALERTTYPE:
				return "Code=30006, Message=Unknown alert type";
			case NO_NEW_FIRMWARE:
				return "Code=30007, Message=No new firmware found";
			case NO_PURCHASEORDER:
				return "Code=40001, Message=No purchase order found for batchID";
			case DATABASE_ERROR:
				return "Code=50001, Message=General database error";
		}
		return "UNKNOWN ERROR";
	}
}