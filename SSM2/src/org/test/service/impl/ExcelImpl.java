package org.test.service.impl;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.entity.Course;
import org.test.entity.Student;
import org.test.entity.Teacher;
import org.test.mapper.CourseMapper;
import org.test.mapper.StudentMapper;
import org.test.mapper.TeacherMapper;


@Service
public class ExcelImpl {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@SuppressWarnings("resource")
	public void exportStu(String[] titles, ServletOutputStream out) throws Exception{
		 try{
	        
	         HSSFWorkbook workbook = new HSSFWorkbook();
	        
	         HSSFSheet hssfSheet = workbook.createSheet("sheet1");
	         
	         HSSFRow row = hssfSheet.createRow(0);
	       
	         HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
	         
	        
	         hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	
	         HSSFCell hssfCell = null;
	         for (int i = 0; i < titles.length; i++) {
	             hssfCell = row.createCell(i);
	             hssfCell.setCellValue(titles[i]);
	             hssfCell.setCellStyle(hssfCellStyle);               
	         }
	         
	         List<Student> list = studentMapper.queryStudentList();
	         
	         for (int i = 0; i < list.size(); i++) {
	             row = hssfSheet.createRow(i+1);                
	             Student stu = list.get(i);
	             // ֵ
	             Integer  id = null;
	             if(stu.getId() != null){
	                 id = stu.getId();
	             }
	             row.createCell(0).setCellValue(id);
	             
	             String name = "";
	             if(stu.getName() != null){
	                 name = stu.getName();
	             }
	             row.createCell(1).setCellValue(name);
	             
	             String sex = "";
	             if(stu.getSex() != null){
	                 sex = stu.getSex();
	             }
	             row.createCell(2).setCellValue(sex);
	             
	             Integer age=null;
	             if(stu.getAge() !=null){
	                 age = stu.getAge();
	             }
	             row.createCell(3).setCellValue(age);
	         }
	
	         try {
	             workbook.write(out);
	             out.flush();
	             out.close();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	     }catch(Exception e){
	         e.printStackTrace();
	        throw new Exception("导出失败");
	        }
	     } 
	
	@SuppressWarnings("resource")
	public void exportCourse(String[] titles, ServletOutputStream out) throws Exception{
		 try{
	        
	         HSSFWorkbook workbook = new HSSFWorkbook();
	        
	         HSSFSheet hssfSheet = workbook.createSheet("sheet1");
	         
	         HSSFRow row = hssfSheet.createRow(0);
	       
	         HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
	     
	         hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	
	         HSSFCell hssfCell = null;
	         for (int i = 0; i < titles.length; i++) {
	             hssfCell = row.createCell(i);
	             hssfCell.setCellValue(titles[i]);
	             hssfCell.setCellStyle(hssfCellStyle);     
	         }
	         
	         List<Course> list = courseMapper.queryCourseList();
	         
	         for (int i = 0; i < list.size(); i++) {
	             row = hssfSheet.createRow(i+1);                
	             Course course = list.get(i);
	             
	             Integer  id = null;
	             if(course.getId() != null){
	                 id = course.getId();
	             }
	             row.createCell(0).setCellValue(id);
	             
	             String name = "";
	             if(course.getName() != null){
	                 name = course.getName();
	             }
	             row.createCell(1).setCellValue(name);
	             
	             Integer hour = null;
	             if(course.getHour() != null){
	                 hour = course.getHour();
	             }
	             row.createCell(2).setCellValue(hour);
	             
	             Double credit = null;
	             if(course.getCredit() !=null){
	                 credit = course.getCredit();
	             }
	             row.createCell(3).setCellValue(credit);
	             
	             String desc = "";
	             if(course.getDesc()!=null) {
	            	 desc = course.getDesc();
	             }
	             row.createCell(4).setCellValue(desc);
	             
	             String remark = "";
	             if(course.getRemark()!=null) {
	            	 remark = course.getRemark();
	             }
	             row.createCell(5).setCellValue(remark);
	             
	             Integer  capacity = null;
	             if(course.getCapacity() != null){
	                 capacity = course.getCapacity();
	             }else {
	            	 capacity = 40;
	             }
	             row.createCell(6).setCellValue(capacity);
	         }
	       
	         try {
	             workbook.write(out);
	             out.flush();
	             out.close();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	     }catch(Exception e){
	         e.printStackTrace();
	        throw new Exception("导出失败");
	        }
	     } 
	
	@SuppressWarnings("resource")
	public void exportTeacher(String[] titles, ServletOutputStream out) throws Exception{
		 try{
	         
	         HSSFWorkbook workbook = new HSSFWorkbook();
	         
	         HSSFSheet hssfSheet = workbook.createSheet("sheet1");
	         
	         HSSFRow row = hssfSheet.createRow(0);
	      
	         HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
	         
	         hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	
	         HSSFCell hssfCell = null;
	         for (int i = 0; i < titles.length; i++) {
	             hssfCell = row.createCell(i);
	             hssfCell.setCellValue(titles[i]);
	             hssfCell.setCellStyle(hssfCellStyle);                
	         }
	         
	         List<Teacher> list = teacherMapper.queryTeacherList();
	         
	         for (int i = 0; i < list.size(); i++) {
	             row = hssfSheet.createRow(i+1);                
	             Teacher teacher = list.get(i);
	                 
	      // ֵ
	             Integer  id = null;
	             if(teacher.getId() != null){
	                 id = teacher.getId();
	             }
	             row.createCell(0).setCellValue(id);
	             
	             String name = "";
	             if(teacher.getName() != null){
	                 name = teacher.getName();
	             }
	             row.createCell(1).setCellValue(name);
	             
	             
	             String sex = "";
	             if(teacher.getSex() != null){
	                 sex = teacher.getSex();
	             }
	             row.createCell(2).setCellValue(sex);
	             
	             
	             String courses = "";
	             if(teacher.getCourseList() != null) {
	            	 for(Course course:teacher.getCourseList()) {
	            		 courses += course.getName()+" ";
	            	 }
	             }
	             row.createCell(3).setCellValue(courses);
	             
	         }
	
	       
	         try {
	             workbook.write(out);
	             out.flush();
	             out.close();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	     }catch(Exception e){
	         e.printStackTrace();
	        throw new Exception("导出失败");
	        }
	     }           
}