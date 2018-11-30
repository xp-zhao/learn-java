package com.xp.basics;

/**
 * Created by xp-zhao on 2018/11/29.
 */
public class Student extends Person
{
	private String studentId;

	public static void main(String[] args) {
		Student student = new Student();
		student.setStudentId("1234");
	}

	public String getStudentId()
	{
		return studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
}
