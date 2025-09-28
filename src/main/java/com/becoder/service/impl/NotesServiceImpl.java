package com.becoder.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.becoder.dto.NotesDto;
import com.becoder.entity.Notes;
import com.becoder.repository.NotesRepostitory;
import com.becoder.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepostitory notesRepostitory;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Boolean saveNotes(NotesDto notesDto) {
		Notes notes = modelMapper.map(notesDto, Notes.class);
		Notes save = notesRepostitory.save(notes);
		if (!ObjectUtils.isEmpty(save)) {
			return true;
		}
		return false;
	}

	@Override
	public List<NotesDto> getAllNotes() {
		// TODO Auto-generated method stub
		return null;
	}

	 

}
