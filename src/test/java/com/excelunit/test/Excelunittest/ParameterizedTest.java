package com.excelunit.test.Excelunittest;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.excelunit.test.Excelunittest.model.UserRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@RunWith(Parameterized.class)
@SpringBootTest
public class ParameterizedTest {
	
String listOfFiles;
	
	
	public ParameterizedTest(String listOfFiles) {
		this.listOfFiles = listOfFiles;
		
		
	}
	
	 @Parameterized.Parameters
	 public static List<String> primeNumbers() {
		 File folder = new File("D:\\Excel-file");
		 File[] listOfFiles = folder.listFiles();
		 List<String> filePath = new ArrayList<String>();
		 for(File file : listOfFiles) {
			filePath.add(file.getPath());
		 }
	      return filePath;
	   }
	 
	@Test 
	public void postapitest() throws IOException, BiffException  {
		
		
		
	
	   
		    
		FileInputStream fs = new FileInputStream(listOfFiles);   
		Workbook wb = Workbook.getWorkbook(fs);
      
		// TO get the access to the sheet
		Sheet sheet = wb.getSheet("Sheet1");
	
		 List<UserRequest> userlist = new ArrayList<UserRequest>();
		
		 System.out.println("-----------------------"+sheet.getRows());
		 for (int row = 1; row < sheet.getRows(); row++) {
			 MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
			 Cell[] cells = sheet.getRow(row);
			
					System.out.println(cells[1].getContents());
					System.out.println(cells[2].getContents());
					System.out.println(cells[3].getContents());
					System.out.println(cells[4].getContents());
					
					
					UserRequest request = new UserRequest();
					
							request.setUrl(cells[1].getContents());
							request.setAction(cells[2].getContents());
							request.setParameter(cells[3].getContents());
							request.setConten_type(cells[4].getContents());
							
							userlist.add(request);
							
							String url = request.getUrl();
							String Action = request.getAction();
							String content_type = request.getConten_type();
							String Parameter = request.getParameter();
							
							String[] param = Parameter.split(",");
							
							
							
							for (int i =0;i<param.length; i++) {					
								 String param2 = param[i];
								 
								if(param2.trim().isEmpty()) {
									continue;
								}
									 
								
								 String[] param12 = param2.split("=");
								 String key = param12[0];
								 String value = param12[1];
								
									
							     
							       
								  bodyMap.add(key,value);
								
								 
								  if (key.equals("file")) {
									 
									  bodyMap.add(key, new FileSystemResource(value));
									  
								  }
								  
									  
							}
							
							    
							 UploadClient uploadClient = new UploadClient();
								String result = uploadClient.uploadfile(url,bodyMap,Action,content_type);
								System.out.println("body send "+bodyMap);
								System.out.println("My final result "+" "+result);
							
						       
		 }
		    
		    
		 		
		 }
	}

			
		

	
		


