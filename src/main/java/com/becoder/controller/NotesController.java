package com.becoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.dto.NotesDto;
import com.becoder.service.NotesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/notes")
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	public ResponseEntity<?> saveNotes(@RequestBody NotesDto notesDto){
		Boolean saveNotes = notesService.saveNotes(notesDto);
		
		if(saveNotes) {
		}
		return null;
	}

}
