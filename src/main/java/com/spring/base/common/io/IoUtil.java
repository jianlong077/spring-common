package com.spring.base.common.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class IoUtil {
	private static final Logger log = LoggerFactory.getLogger(IoUtil.class);

	/**
	 * 读取文件
	 * 
	 * @param fromFile
	 * @return
	 * @throws IOException
	 */
	public synchronized static String readFile(String fromFile) throws IOException {
		String utf = "utf-8";
		return readFile(fromFile, utf);
	}

	/**
	 * 读取文件
	 * 
	 * @param fromFile
	 * @param utf
	 * @return
	 * @throws IOException
	 */
	public synchronized static String readFile(String fromFile, String utf) throws IOException {
		long startTime = System.currentTimeMillis();
		StringBuffer line = new StringBuffer();
		File file = new File(fromFile);
		if (!file.getParentFile().exists()) {
			boolean result = file.getParentFile().mkdirs();
			if (!result) {
				System.out.println("创建失败");
			}
		}
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis, utf), 30 * 1024 * 1024);// 用5M的缓冲读取文本文件
		String s;
		while ((s = reader.readLine()) != null) {
			line.append(s);
		}

		reader.close();
		long endTime = System.currentTimeMillis();
		log.info("读取文件耗时  " + (endTime - startTime) / 1000 + " 秒");
		return line.toString();
	}

	/**
	 * 写入文件
	 * 
	 * @param fromFile
	 * @param content
	 * @throws IOException
	 */
	public synchronized static void writeFile(String fromFile, String content) throws IOException {
		File file = new File(fromFile);
		if (!file.getParentFile().exists()) {
			boolean result = file.getParentFile().mkdirs();
			if (!result) {
				System.out.println("创建失败");
			}
		}
		long startTime = System.currentTimeMillis();
		// 创建输出流对象"
		FileWriter fw = new FileWriter(fromFile);

		// 调用输出流对象写数据的方法
		// 写一个字符串数据
		fw.write(content);
		// 数据没有写到文件里，只写到缓冲区
		fw.flush();
		// 释放资源
		// 通知系统释放和该文件相关的资源
		// close()，刷新缓冲区，通知系统释放资源。流对象不可以再使用。后面无法继续写数据。
		fw.close();
		long endTime = System.currentTimeMillis();
		log.info("写入文件耗时  " + (endTime - startTime) / 1000 + " 秒");
	}
	 //利用了java运行时的系统属性来得到jar文件位置，也是/xxx/xxx.jar这种形式。 path="Excel/ole.xlsx"
	public static String convertResourceTemplatePath(String path) {
        // 如果是windows 则直接返回
        // if (System.getProperties().getProperty("os.name").contains("Windows")) {
        // return path;
        // }

        Resource resource = new ClassPathResource(path);
        FileOutputStream fileOutputStream = null;
        // 将模版文件写入到 tomcat临时目录
        String folder = System.getProperty("catalina.home");
        File tempFile = new File(folder + File.separator + path);
        // System.out.println("文件路径：" + tempFile.getPath());
        // 文件存在时 不再写入
        if (tempFile.exists()) {
            return tempFile.getPath();
        }
        File parentFile = tempFile.getParentFile();
        // 判断父文件夹是否存在
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(resource.getInputStream());
            fileOutputStream = new FileOutputStream(tempFile);
            byte[] buffer = new byte[10240];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tempFile.getPath();
    }
}
