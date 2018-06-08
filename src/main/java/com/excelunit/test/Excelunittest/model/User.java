package com.excelunit.test.Excelunittest.model;

public class User {


		private int id;
		private String email;
	    private String name;
	    private String password;
	    
	    
	   User(int id,String email,String name,String password){
	    	    this.id = id;
	    		this.email = email;
	    		this.name = name;
	    		this.password = password;
	    }
	  public User(){}
	   
	 	public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	  
	    public String getemail() {
	        return email;
	    }
	  
	    public String getName() {
	        return name;
	    }
	  
	  
	    public void setemail(String email) {
	        this.email = email;
	    }
	  
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	}

