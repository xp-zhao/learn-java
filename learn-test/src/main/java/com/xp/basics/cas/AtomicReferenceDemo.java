package com.xp.basics.cas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by xp-zhao on 2019/4/17.
 */
@Data
@AllArgsConstructor
class User{
	String userName;
	int age;
}

public class AtomicReferenceDemo
{
	public static void main(String[] args) {
		User user1 = new User("zhangsan" , 22);
		User user2 = new User("lisi" , 23);
		AtomicReference<User> atomicReference = new AtomicReference<>();
		atomicReference.set(user1);
		System.out.println(atomicReference.compareAndSet(user1,user2) + "\t" + atomicReference.get().toString());
		System.out.println(atomicReference.compareAndSet(user1,user2) + "\t" + atomicReference.get().toString());
	}
}
