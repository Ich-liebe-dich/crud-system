package org.test.constant;

public class Constant {
	
	//导出Excel时的列名
    public static final String STUTITLE[] = { "学号", "姓名", "性别", "年龄" };
    public static final String COURSETITLE[] = {"课程编号","课程名","学时","学分","描述","备注","课程容量"};
    public static final String TEACHERTITLE[] = {"教师编号","姓名","性别","课程"};
    
    // 登录界面的名称
 	public static final String LOGIN = "loginForm";
 	
 	// session变量
 	public static final String USER_SESSION = "user_session";
 	public static final String USER_TYPE = "user_type";
 	
 	//页面默认显示数据为4
 	public static int PAGE_DEFAULT_SIZE = 4;
 	
 	//
 	public static int IDENTITY_ADMIN = 0;
 	public static int IDENTITY_TEACHER = -1;
 	public static int IDENTITY_STU = -2;
 
}
