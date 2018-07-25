package org.litespring.service.v2;

import org.litespring.dao.v2.AccountDao;
import org.litespring.dao.v2.ItemDao;

/**
 * Created by xp-zhao on 2018/7/25.
 */
public class PetStoreService
{
	private AccountDao accountDao;
	private ItemDao itemDao;

	public AccountDao getAccountDao()
	{
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	}

	public ItemDao getItemDao()
	{
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao)
	{
		this.itemDao = itemDao;
	}
}
