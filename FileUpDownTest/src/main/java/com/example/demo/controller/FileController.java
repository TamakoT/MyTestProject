package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import com.example.demo.entity.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 19:17
 */
@RestController
@RequestMapping("/file")
public class FileController {

	@PostMapping("/upload")
	public String upload(User user, @RequestPart("file") MultipartFile file) {
		String extName = FileUtil.extName(file.getOriginalFilename());
		System.out.println("file original name : " + file.getOriginalFilename());
		System.out.println("Type : " + extName);
		System.out.println("size : " + file.getSize() / 1024);
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return user.getName() + " " + user.getPassword() + " " + "成功接收！";
	}

	@GetMapping("download")
	public String download(HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data");
		response.reset();
		response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("爱你哟.xlsx", "UTF-8"));
		File file = new File("D:\\userDemoWriter.xlsx");
		downLoadHandler(file, response);
		return "下载已开始，请等待下载完成";
	}

	@Async
	public void downLoadHandler(File file, HttpServletResponse response) {
		try (InputStream is = new FileInputStream(file);
		     OutputStream os = response.getOutputStream();) {
			Thread.sleep(100);
			byte[] buffer = new byte[10];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
				os.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
