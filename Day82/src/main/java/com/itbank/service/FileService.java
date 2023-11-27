package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.FileDAO;
import com.itbank.model.dto.FileDTO;

@Service
public class FileService {
	
	@Autowired private FileDAO dao;

	@Value("file:D:\\SpringUpload")
	private Resource rs;
	
	public File[] getDir() throws IOException {
		File dir = rs.getFile();
		
//		System.out.println("존재하냐? " + dir.exists());
//		System.out.println("파일인가? " + dir.isFile());
//		System.out.println("폴더인가? " + dir.isDirectory() + "\n");
		
		if(dir.exists() == false) {		// 존재하지 않으면
			dir.mkdir();				// 폴더를 생성하라
		}
		
//		for (File file : dir.listFiles()) {
//			System.out.println(file.getName());
//		}
		
		return dir.listFiles();
	}

	public void fileUpload(MultipartFile upload) throws IOException {
		File dest = new File(rs.getFile(), upload.getOriginalFilename());
		
		upload.transferTo(dest);
	}

	public void fileUpload(MultipartFile upload, String name) throws IOException {
		String oName = upload.getOriginalFilename();
		String ext = oName.substring(oName.lastIndexOf("."));
		
		name = ("".equals(name)) ? oName : name + ext;
		// ※input에서 값을 작성하지 않고 보내면 null이 아닌 빈 문자열이다
		
		File dest = new File(rs.getFile(), name);
		upload.transferTo(dest);
	}

	public void fileUpload(FileDTO input) throws IOException {
		MultipartFile file = input.getUpload();		
		
		// 1. DB에 전달할 값을 분할
		input.setPath(rs.getFile().toString());
		input.setName(file.getOriginalFilename());
		
		// 2. 실제 위치에 업로드 진행
		File dest = new File(rs.getFile(), file.getOriginalFilename());
		file.transferTo(dest);
		
		// 3. DB 정보 등록
		dao.insert(input);
	}

	@Transactional(readOnly = true)
	public List<FileDTO> getFiles() {		
		return dao.selectAll();
	}

	public int deleteFile(FileDTO input) throws IOException {
		File file = new File(rs.getFile(), input.getName());
		
		if (file.exists()) {
			file.delete();
		}
		
		return dao.delete(input);
	}

	public FileDTO getFile(int idx) {
		return dao.selectOne(idx);
	}

	public int updateFile(FileDTO input) throws IOException {
		// 원본, 대상
		FileDTO file = dao.selectOne(input.getIdx());
		
		File src = new File(rs.getFile(), file.getName());
		File dst = new File(rs.getFile(), input.getName());
		
		src.renameTo(dst);
		
		return dao.update(input);
	}

}
