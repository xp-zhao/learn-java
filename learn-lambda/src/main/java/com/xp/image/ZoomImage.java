package com.xp.image;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * 图片压缩示例
 */
public class ZoomImage {
    public static void main(String[] args) throws IOException {
        String path = "/Users/hejuan/Desktop/2.jpg";
        String newPath = "/Users/hejuan/Desktop/1-3.jpg";
        File file = new File(path);
        System.out.println("hello");
        System.out.println(file.getName());
        Thumbnails.of(file)
                .scale(0.6f)
                .outputQuality(1f)
                .toFile(new File(newPath));
        Thumbnails.of(new File(newPath))
                .scale(1f)
                .outputQuality(0.25f)
                .toFile(new File(newPath));
    }
}