package com.xp.basics.hash;

/**
 * Created by xp-zhao on 2019/4/3.
 */
public class Key
{
	private Integer id;

	public Integer getId() {
		return id;
	}

	public Key(Integer id) {
		this.id = id;
	}

	public boolean equals(Object obj){
		if(obj == null || !(obj instanceof Key)){
			return false;
		}else{
			return this.getId().equals(((Key) obj).getId());
		}
	}

	public int hashCode(){
		return id.hashCode();
	}
}
