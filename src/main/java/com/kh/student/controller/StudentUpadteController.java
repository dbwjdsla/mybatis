package com.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.vo.Student;

public class StudentUpadteController extends AbstractController {

	private IStudentService studentService;

	public StudentUpadteController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}



	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 사용자입력값
		int no = Integer.valueOf(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Student student = new Student(no, name, tel, null);
		System.out.println("업데이트학생 [student] = " + student);
		
		//2. 업무로직
		int result = studentService.updateStudent(student);
//		String msg = result > 0 ? "학생 정보 수정완료!" : "학생 정보 수정실패";
//		request.getSession().setAttribute("msg", msg);
		
		
		response.setContentType("application/json; charset=utf-8");
//		new Gson().toJson(msg, response.getWriter());
		new Gson().toJson(result, response.getWriter());
		
		return null;
		
	}
	
	
}
