package com.xp;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xp.dao.EmployeeDao;
import com.xp.model.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/7/5.
 */
public class TespMP
{
	private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private EmployeeDao employeeDao = context.getBean("employeeDao" , EmployeeDao.class);

	@Test
	public void testEnv() throws SQLException
	{
		DataSource dataSource = context.getBean("dataSource" , DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

	@Test
	public void testInsert()
	{
		Employee employee = new Employee();
		employee.setLastName("xp");
		employee.setEmail("1132813751@qq.com");
		employee.setAge(24);
//		Integer result = employeeDao.insert(employee);
		Integer result = employeeDao.insertAllColumn(employee);
		System.out.println("result: " + result );
		//获取当前数据在数据库中的主键值
		Integer key = employee.getId();
		System.out.println("key:" + key );
	}

	@Test
	public void testUpdate()
	{
		Employee employee = new Employee();
		employee.setId(6);
		employee.setLastName("hj");
		employee.setEmail("hj@sina.com");
		employee.setGender(0);
		//employee.setAge(33);

		Integer result = employeeDao.updateById(employee);
//		Integer result = employeeDao.updateAllColumnById(employee);
		System.out.println("result: " + result );
	}

	/**
	 * 通用 查询操作
	 */
	@Test
	public void  testSelect() {
		//1. 通过id查询
//		Employee employee = employeeDao.selectById(6);
//		System.out.println(employee);

		//2. 通过多个列进行查询    id  +  lastName
//		Employee  employee = new Employee();
//		employee.setId(6);
//		employee.setLastName("hj");
//		employee.setGender(0);
//
//		Employee result = employeeDao.selectOne(employee);
//		System.out.println("result: " +result );


		//3. 通过多个id进行查询    <foreach>
//		List<Integer> idList = new ArrayList<>();
//		idList.add(1);
//		idList.add(2);
//		idList.add(3);
//		idList.add(4);
//		List<Employee> emps = employeeDao.selectBatchIds(idList);
//		System.out.println(emps);

		//4. 通过Map封装条件查询
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "xp");
//		columnMap.put("gender", null);
//
//		List<Employee> emps = employeeDao.selectByMap(columnMap);
//		System.out.println(emps);

//		//5. 分页查询
//		List<Employee> emps = employeeDao.selectPage(new Page<>(1, 2), null);
//		System.out.println(emps);
	}

	/**
	 * 通用 删除操作
	 */
	@Test
	public void testDelete() {
		//1 .根据id进行删除
//		Integer result = employeeDao.deleteById(1);
//		System.out.println("result: " + result );
		//2. 根据 条件进行删除
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "MP");
//		columnMap.put("email", "mp@atguigu.com");
//		Integer result = employeeDao.deleteByMap(columnMap);
//		System.out.println("result: " + result );

		//3. 批量删除
		List<Integer> idList = new ArrayList<>();
		idList.add(3);
		idList.add(4);
		idList.add(5);
		Integer result = employeeDao.deleteBatchIds(idList);
		System.out.println("result: " + result );
	}

	/**
	 * 条件构造器   查询操作
	 */
	@Test
	public void testEntityWrapperSelect() {
		//分页查询tbl_employee表中，年龄在18~50之间且性别为男且姓名为Tom的所有用户
//		List<Employee> emps =employeeDao.selectPage(new Page<Employee>(1, 2),
//					new EntityWrapper<Employee>()
//					.between("age", 18, 50)
//					.isNull("gender")
//					.eq("last_name", "xp")
//				);
//		System.out.println(emps);

//		List<Employee > emps = employeeDao.selectPage(
//			new Page<Employee>(1,2),
//			Condition.create()
//				.between("age", 18, 50)
//				.eq("gender", "1")
//				.eq("last_name", "Tom")
//
//		);
//		System.out.println(emps);
		// 查询tbl_employee表中， 性别为女并且名字中带有"老师" 或者  邮箱中带有"a"
//		List<Employee> emps = employeeDao.selectList(
//				new EntityWrapper<Employee>()
//				.eq("gender", 0)
//				.like("last_name", "j")
//				//.or()    // SQL: (gender = ? AND last_name LIKE ? OR email LIKE ?)
//				.orNew()   // SQL: (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
//				.like("email", "a")
//				);
//		System.out.println(emps);

		// 查询性别为女的, 根据age进行排序(asc/desc), 简单分页

		List<Employee> emps  = employeeDao.selectList(
				new EntityWrapper<Employee>()
				.eq("gender", 0)
				.orderBy("age")
				//.orderDesc(Arrays.asList(new String [] {"age"}))
				.last("desc limit 1,3")
				);
		System.out.println(emps);

	}

	/**
	 * 条件构造器  修改操作
	 */
	@Test
	public void testEntityWrapperUpdate() {

		Employee employee = new Employee();
		employee.setLastName("苍老师");
		employee.setEmail("cls@sina.com");
		employee.setGender(0);
		employeeDao.update(employee,
			new EntityWrapper<Employee>()
				.eq("last_name", "Black")
				.eq("age", 30)
		);
	}

	/**
	 * 条件构造器  删除操作
	 */
	@Test
	public void testEntityWrapperDelete() {

		employeeDao.delete(
			new EntityWrapper<Employee>()
				.eq("last_name", "Jerry")
				.eq("age", 25)
		);
	}
}
