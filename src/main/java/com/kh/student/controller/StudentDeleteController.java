package com.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;

public class StudentDeleteController extends AbstractController {

	private IStudentService studentService;

	public StudentDeleteController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. 사용자 입력값
		int no = Integer.valueOf(request.getParameter("no"));

		//2. 업무로직
		int result = studentService.deleteStudent(no);
		String msg = result > 0 ? "학생 정보 삭제완료!" : "학생 정보 삭제실패";
		request.getSession().setAttribute("msg", msg);
		
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(msg, response.getWriter());
		
		
		
		
		
		return null;
	}

	
}
