package com.tamako.controller;

import com.alibaba.excel.EasyExcel;
import com.tamako.entity.User;
import com.tamako.service.IUserService;
import com.tamako.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
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

	@Autowired
	private IUserService userService;

	@PostMapping("/upload")
	public String upload(User user, @RequestPart("file") MultipartFile file) {
		System.out.println(user.getName());
		System.out.println(user.getNumber());
		try (InputStream inputStream = file.getInputStream()) {
			EasyExcel.read(inputStream, User.class, ExcelUtil.getDataListener(userService, 10)).sheet().doRead();
		} catch (IOException e) {
			return "服务器内部文件IO异常";
		}
		return user.getName() + " " + user.getNumber() + " " + "成功接收！";
	}

	@GetMapping("/download")
	public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data");
		response.reset();
		response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("用户表.xlsx", "UTF-8"));
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			EasyExcel.write(outputStream, User.class).sheet("文件输出测试").doWrite(userService.list());
		}
		return "redirect:/file/upload";
	}

}
