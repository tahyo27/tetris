package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.UploadFile;

@Component
public class FileStore {
	private final String rootPath = System.getProperty("user.dir");//현재 경로 불러오기
	private final String fileDir = rootPath + "/files/"; //파일 저장위치
	
	public String getFullPath(String filenmae) {
		return fileDir + filenmae; //파일경로 불러오기
	}
	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		if(multipartFile.isEmpty()) {
			return null;
		}
		//첨부되는 오리지널 파일명
		String originalFilename = multipartFile.getOriginalFilename();
		//파일명을 중복되지 않게 UUID 확장자는 그대로
		String storeFilename = UUID.randomUUID() + "." + extractExt(originalFilename);
		//파일을 저장하는 부분 -> 파일경로 + storeFilename에 저장
		multipartFile.transferTo(new File(getFullPath(storeFilename)));
		
		return new UploadFile(originalFilename, storeFilename); //업로드 파일에 저장이름 오리지널 이름 넣어줌
		
	}
	
	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException{
		List<UploadFile> storeFileResult = new ArrayList<>();
		for(MultipartFile multipartFile : multipartFiles) {
			if(!multipartFile.isEmpty()) {
				storeFileResult.add(storeFile(multipartFile));
			}
		}
		return storeFileResult;
	}
	
	
	//확장자 추출 메소드
	private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf("."); //마지막 . 위치 확장자 바로 앞 찾기
		return originalFilename.substring(pos + 1); //. 이후부터 서브스트링으로 가져옴
	}
}
