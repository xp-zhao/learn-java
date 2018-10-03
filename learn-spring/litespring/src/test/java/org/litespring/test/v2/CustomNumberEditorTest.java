package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.propertyeditors.CustomNumberEditor;

/**
 * Created by xp-zhao on 2018/10/3.
 */
public class CustomNumberEditorTest
{
	@Test
	public void testConvertString() {
		CustomNumberEditor editor = new CustomNumberEditor(Integer.class,true);

		editor.setAsText("3");
		Object value = editor.getValue();
		Assert.assertTrue(value instanceof Integer);
		Assert.assertEquals(3, ((Integer)editor.getValue()).intValue());

		editor.setAsText("");
		Assert.assertTrue(editor.getValue() == null);

		try{
			editor.setAsText("3.1");

		}catch(IllegalArgumentException e){
			return ;
		}
		Assert.fail();

	}
}
