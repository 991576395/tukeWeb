package com.xuzy.hotel.ylrequest.module;

/**
 * Created by uatzx03548 on 2018/10/29.
 */
public class LoginBody extends  BaseBody{
    private String UserName;

    private String Password;
    
    private String ExtPropertys="";
    
    

    public String getExtPropertys() {
		return ExtPropertys;
	}

	public void setExtPropertys(String extPropertys) {
		ExtPropertys = extPropertys;
	}

	public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

   
}
