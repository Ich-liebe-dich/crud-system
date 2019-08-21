package org.test.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.constant.Constant;
import org.test.service.impl.ExcelImpl;

/**
 * 导出excel
 * @author DELL
 *
 */
@Controller
@RequestMapping(value="excel")  
public class ExcelController {
	
	@Autowired
    ExcelImpl  excleImpl;
    
	@RequestMapping("stu")
	@ResponseBody
	public String downStu(HttpServletResponse response,@RequestParam("name") String name){
	     response.setContentType("application/binary;charset=UTF-8");
	     try{
             ServletOutputStream out=response.getOutputStream();
             try {
                 response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name+".xls", "UTF-8"));
             } catch (UnsupportedEncodingException e1) {
                 e1.printStackTrace();
             }
             excleImpl.exportStu(Constant.STUTITLE, out);      
             return "stu/showSelectStu/1";
         } catch(Exception e){
             e.printStackTrace();
             return "导出失败";
         }
     } 
	
	@RequestMapping("course")
	@ResponseBody
	public String downCourse(HttpServletResponse response,@RequestParam("name") String name){
	     response.setContentType("application/binary;charset=UTF-8");
	     try{
             ServletOutputStream out=response.getOutputStream();
             try {
                
                 response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name+".xls", "UTF-8"));
             } catch (UnsupportedEncodingException e1) {
                 e1.printStackTrace();
             }
             excleImpl.exportCourse(Constant.COURSETITLE, out);      
             return "stu/showSelectCourse/1";
         } catch(Exception e){
             e.printStackTrace();
             return "导出失败";
         }
     }
	
	@RequestMapping("teacher")
	@ResponseBody
	public String downTeacher(HttpServletResponse response,@RequestParam("name") String name){
	     response.setContentType("application/binary;charset=UTF-8");
	     try{
             ServletOutputStream out=response.getOutputStream();
             try {
                
                 response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name+".xls", "UTF-8"));
             } catch (UnsupportedEncodingException e1) {
                 e1.printStackTrace();
             }
             excleImpl.exportTeacher(Constant.TEACHERTITLE, out);      
             return "stu/showSelectTeacher/1";
         } catch(Exception e){
             e.printStackTrace();
             return "导出失败";
         }
     }
	
	
}