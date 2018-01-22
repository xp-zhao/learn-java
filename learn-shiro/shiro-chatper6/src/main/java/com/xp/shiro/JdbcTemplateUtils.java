package com.xp.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by xp-zhao on 2018/1/22.
 */
public class JdbcTemplateUtils
{
	private static JdbcTemplate jdbcTemplate;

	public static JdbcTemplate jdbcTemplate()
	{
		if(jdbcTemplate == null)
		{
			jdbcTemplate = createJdbcTemplate();
		}
		return jdbcTemplate;
	}

	private static JdbcTemplate createJdbcTemplate()
	{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shiro");
		dataSource.setUsername("root");
		dataSource.setPassword("159669");

		return new JdbcTemplate(dataSource);
	}
}
