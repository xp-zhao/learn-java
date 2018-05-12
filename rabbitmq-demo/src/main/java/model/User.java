package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xp-zhao on 2018/5/12.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
	String username;
	String password;
	String desc;
}
