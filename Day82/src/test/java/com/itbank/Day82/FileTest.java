package com.itbank.Day82;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itbank.model.FileDAO;

public class FileTest {

	@Autowired private FileDAO dao;
	
	@Test
	@Ignore
	public void test() {
		File dir = new File("D:\\SpringUpload");
		
		System.out.println("존재 ? " + dir);
		
		// 지정 폴더 간 파일 목록
//		for(File file : dir.listFiles()) {
//			System.out.println(file);
//		}
		
		// 폴더에서 파일 하나 지정
		File file = new File(dir, "DBCP 설정.txt");
		
		System.out.println("존재 ?" + file.exists());
		
		// 삭제 후 확인
		if (file.exists()) {			
			file.delete();
		}
		System.out.println("존재 ?" + file.exists());
		
		// 다른 파일로 저장
		file= new File(dir, "spring-mvc.png");
		File dest = new File(dir, "이름 변경.png");
		
		System.out.println("file 존재 ?" + file.exists());						
		System.out.println("dest 존재 ?" + dest.exists());
		
		file.renameTo(dest);
		System.out.println("file 존재 ?" + file.exists());
		System.out.println("dest 존재 ?" + dest.exists());
	}

	@Test
	public void test2() {
		System.out.println(dao.selectOne(1004));
	}
}
