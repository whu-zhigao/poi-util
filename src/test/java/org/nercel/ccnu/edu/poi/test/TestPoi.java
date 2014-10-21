package org.nercel.ccnu.edu.poi.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.nercel.ccnu.edu.poi.model.Student;
import org.nercel.ccnu.edu.poi.model.User;
import org.nercel.ccnu.edu.poi.util.ExcelTemplate;
import org.nercel.ccnu.edu.poi.util.ExcelUtil;

@SuppressWarnings({"rawtypes","unchecked"})
public class TestPoi {

	@Test
	public void test01() {
		ExcelTemplate et = ExcelTemplate.getInstance()
					.readTemplateByClasspath("/excel/user.xls");
		et.createNewRow();
		et.createCell("1111111");
		et.createCell("aaaaaaaaaaaa");
		et.createCell("a1");
		et.createCell("a2a2");
		et.createNewRow();
		et.createCell("222222");
		et.createCell("bbbbb");
		et.createCell("b");
		et.createCell("dbbb");
		et.createNewRow();
		et.createCell("3333333");
		et.createCell("cccccc");
		et.createCell("a1");
		et.createCell(12333);
		et.createNewRow();
		et.createCell("4444444");
		et.createCell("ddddd");
		et.createCell("a1");
		et.createCell("a2a2");
		et.createNewRow();
		et.createCell("555555");
		et.createCell("eeeeee");
		et.createCell("a1");
		et.createCell(112);
		et.createNewRow();
		et.createCell("555555");
		et.createCell("eeeeee");
		et.createCell("a1");
		et.createCell("a2a2");
		et.createNewRow();
		et.createCell("555555");
		et.createCell("eeeeee");
		et.createCell("a1");
		et.createCell("a2a2");
		et.createNewRow();
		et.createCell("555555");
		et.createCell("eeeeee");
		et.createCell("a1");
		et.createCell("a2a2");
		et.createNewRow();
		et.createCell("555555");
		et.createCell("eeeeee");
		et.createCell("a1");
		et.createCell("a2a2");
		et.createNewRow();
		et.createCell("555555");
		et.createCell("eeeeee");
		et.createCell("a1");
		et.createCell("a2a2");
		et.createNewRow();
		et.createCell("555555");
		et.createCell("eeeeee");
		et.createCell("a1");
		et.createCell("a2a2");
		Map<String,String> datas = new HashMap<String,String>();
		datas.put("title","测试用户信息");
		datas.put("date","2014-08-10 12:33");
		datas.put("dep","Test");
		et.replaceFinalData(datas);
		et.insertSer();
		et.writeToFile("e:/test/poi/test01.xls");
	}
	
	@Test
	public void testObj2Xls() {
		List<User> users = new ArrayList<User>();
		users.add(new User(1,"aaa","水水水",11));
		users.add(new User(2,"sdf","水水水",11));
		users.add(new User(3,"sdfde","水水水",11));
		users.add(new User(4,"aaa","水水水",11));
		users.add(new User(54,"aaa","水水水",11));
		users.add(new User(16,"aaa","水水水",11));
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(new HashMap<String,String>(),"/excel/user.xls","e:/test/poi/tus.xls", users, User.class, true);
	}
	
	@Test
	public void testObj2Xls2() {
		List<Student> stus = new ArrayList<Student>();
		stus.add(new Student(1,"张三","1123123", "男"));
		stus.add(new Student(2,"张三","1123123", "男"));
		stus.add(new Student(3,"张三","1123123", "男"));
		stus.add(new Student(4,"张三","1123123", "男"));
		ExcelUtil.getInstance().exportObj2Excel("e:/test/poi/ss1.xls",stus, Student.class, false);
	}
	
	@Test
	public void testBeanutil() {
		try {
			Class us = User.class;
			Object obj = us.newInstance();
			BeanUtils.copyProperty(obj, "username","张三");
			String str = BeanUtils.getProperty(obj,"username");
			System.out.println(str);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRe() {
		try {
			String method = "setUsername";
			
			Class us = User.class;
			Object obj = us.newInstance();
			Method m = us.getDeclaredMethod(method,String.class);
			m.invoke(obj, "张三");
			Method m2 = us.getDeclaredMethod("getUsername");
			System.out.println(m2.invoke(obj));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRead01() {
		List<Object> stus = ExcelUtil.getInstance().readExcel2ObjsByPath("e:/test/poi/ss1.xls",Student.class);
		for(Object obj:stus) {
			Student stu = (Student)obj;
			System.out.println(stu);
		}
	}
	
	@Test
	public void testRead02() {
		List<Object> stus = ExcelUtil.getInstance().readExcel2ObjsByPath("e:/test/poi/tus.xls",User.class,1,2);
		for(Object obj:stus) {
			User stu = (User)obj;
			System.out.println(stu);
		}
	}
}
