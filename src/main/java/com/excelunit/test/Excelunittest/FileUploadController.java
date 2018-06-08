package com.excelunit.test.Excelunittest;


import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excelunit.test.Excelunittest.model.User;
import com.excelunit.test.Excelunittest.services.UserService;



@RestController
public class FileUploadController {
	@Autowired
	UserService userservice;
	private static final Logger logger = Logger.getLogger(SpringBootApplication.class.getName());
	
    @RequestMapping(value="/fileupload", method = RequestMethod.POST )
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile,
    		@RequestParam(value = "date") String date ,
    		@RequestParam(value = "name") String name) 
    				throws IOException {

        String name1 = multipartFile.getOriginalFilename();
         
        logger.log(Level.INFO,"File name: "+name1);
        
        //todo save to a file via multipartFile.getInputStream()
        byte[] bytes = multipartFile.getBytes();
        logger.log(Level.INFO,"File uploaded content:\n"+ new String(bytes));
       
        return "file uploaded";
    }
    
    @RequestMapping(value="/User/{id}", method = RequestMethod.GET )
    public User getUser(@PathVariable(value ="id") String id)  {
									
    	return userservice.getUser(id);
    	
    	
    }
    @RequestMapping(value="/check", method = RequestMethod.GET  )
    public String getcheck() {
		
    	
    	return "Get Check API Controller";
    	
    	
    }
    
    @RequestMapping(value="/User{name}{email}{password}", method = RequestMethod.POST)
    @ResponseBody
    public String Usercheck(@PathVariable("name") String name,
    		@PathVariable("email") String email ,
    		@PathVariable("password") String password) throws IOException 
    				 {

  
    	User user = new User();
    	
    	user.setId(22);
    	user.setName(name);
    	user.setemail(email);
    	user.setPassword(password);
       
        return "POST USER Chechk succefully";
    }
    
    @RequestMapping("/AllUser")
    public Hashtable<String, User> getAll(){
    	return userservice.getAll();
    	
    }
    @RequestMapping(value="/Delete/{id}", method = RequestMethod.DELETE )
    public User deleteUser(@PathVariable(value ="id") String id)  {
									
    	return userservice.deleteUser(id);
}
    
}


