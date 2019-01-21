package com.xp.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xp-zhao on 2019/1/11.
 */
public class FileReader
{
	public static void main(String[] args) throws IOException
	{
//		Files.lines(Paths.get("C:\\Users\\ch113\\Desktop\\数据\\result79.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\ch113\\Desktop\\数据\\result79.txt"));
		List<FileModel> fileModels = new ArrayList<>(lines.size());
		for(String line : lines)
		{
			String[] strs = line.split(",");
			fileModels.add(new FileModel(strs[0],strs[1],strs[2]));
		}
		Map<String,List<FileModel>> map = fileModels.stream().collect(Collectors.groupingBy(FileModel::getPhone));
		Path path = Paths.get("C:\\Users\\ch113\\Desktop\\数据\\test.txt");
		map.forEach((k, v) -> {
			try
			{
				Files.write(path,(k.replaceAll("\"","")+",633690000322,600902000009545406\n").getBytes(), StandardOpenOption.APPEND);
				for(FileModel fileModel : v)
				{
					Files.write(path,("	" + fileModel.getDate() + fileModel.getUrl()+"\n").getBytes(), StandardOpenOption.APPEND);

				}

			}
			catch (Exception e)
			{
			}
		});
	}
}
