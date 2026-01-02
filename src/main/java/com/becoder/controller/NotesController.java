package com.becoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.dto.NotesDto;
import com.becoder.service.NotesService;
import com.becoder.utils.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/notes")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@PostMapping("/save")
	public ResponseEntity<?> saveNotes(@RequestBody NotesDto notesDto) {
		Boolean saveNotes = notesService.saveNotes(notesDto);

		if (saveNotes) {
			return CommonUtil.createBuildResponseMessage(HttpStatus.CREATED, "Notes saved successfully");
		}
		return CommonUtil.createErrorResponseMessage(HttpStatus.BAD_REQUEST, "notes not saved");
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllNotes() {
		List<NotesDto> allNotes = notesService.getAllNotes();

		if (CollectionUtils.isEmpty(allNotes)) {
			return ResponseEntity.noContent().build();
		} else {
			return CommonUtil.createBuildResponse(allNotes, HttpStatus.OK);
		}
	}

}
