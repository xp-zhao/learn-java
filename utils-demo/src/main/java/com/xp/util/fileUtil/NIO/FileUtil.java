package com.xp.util.fileUtil.NIO;

/**
 * Created by xp-zhao on 2017/9/22.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

public class FileUtil {

	/**
	 * 通过BufferedRandomAccessFile读取文件,推荐
	 *
	 * @param file     源文件
	 * @param encoding 文件编码
	 * @param pos      偏移量
	 * @param num      读取量
	 * @return pins文件内容，pos当前偏移量
	 */
	public static Map<String, Object> BufferedRandomAccessFileReadLine(File file, String encoding, long pos, int num) {
		Map<String, Object> res = Maps.newHashMap();
		List<String> pins = Lists.newArrayList();
		int count = 0;
		res.put("pins", pins);
		BufferedRandomAccessFile reader = null;
		try {
			reader = new BufferedRandomAccessFile(file, "r",10 * 1024 * 1024);
			reader.seek(pos);
			for (int i = 0; i < num; i++) {
						String pin = reader.readLine();
						if (StringUtils.isBlank(pin)) {
							break;
						}
				count++;
				pins.add(new String(pin.getBytes("8859_1"), encoding));
		}
			res.put("pos", reader.getFilePointer());
			res.put("count",count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
		}
		return res;
	}

	/**
	 * 通过RandomAccessFile读取文件，能出来大数据文件，效率低
	 *
	 * @param file     源文件
	 * @param encoding 文件编码
	 * @param pos      偏移量
	 * @param num      读取量
	 * @return pins文件内容，pos当前偏移量
	 */
	public static Map<String, Object> readLine(File file, String encoding, long pos, int num) {
		Map<String, Object> res = Maps.newHashMap();
		List<String> pins = Lists.newArrayList();
		res.put("pins", pins);
		RandomAccessFile reader = null;
		try {
			reader = new RandomAccessFile(file, "r");
			reader.seek(pos);
			for (int i = 0; i < num; i++) {
				String pin = reader.readLine();
				if (StringUtils.isBlank(pin)) {
					break;
				}
				pins.add(new String(pin.getBytes("8859_1"), encoding));
			}
			res.put("pos", reader.getFilePointer());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
		}
		return res;
	}

	/**
	 * 使用LineNumberReader读取文件，1000w行比RandomAccessFile效率高，无法处理1亿条数据
	 *
	 * @param file     源文件
	 * @param encoding 文件编码
	 * @param index    开始位置
	 * @param num      读取量
	 * @return pins文件内容
	 */
	public static List<String> readLine(File file, String encoding, int index, int num) {
		List<String> pins = Lists.newArrayList();
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(new InputStreamReader(new FileInputStream(file), encoding));
			int lines = 0;
			while (true) {
				String pin = reader.readLine();
				if (StringUtils.isBlank(pin)) {
					break;
				}
				if (lines >= index) {
					if (StringUtils.isNotBlank(pin)) {
						pins.add(pin);
					}
				}
				if (num == pins.size()) {
					break;
				}
				lines++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
		}
		return pins;
	}


}
