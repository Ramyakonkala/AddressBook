package com.bvrith.model;
import java.util.*;

public class Model {
	public boolean validateUser(String user,String password){
		
		HashMap<String, String> list = new HashMap<String, String>();
		list.put("ramya","12345");
		list.put("chitti","1995");
		list.put("chinni","1814");
		boolean result = false;
		if(list.containsKey(user)){
			if(password.equals(list.get(user))){
				result = true;
			}
	    }
		return result;
		}
		
	}
