package com.example.petproject.services;

import com.example.petproject.dtos.ResumeRequestDto;
import com.example.petproject.dtos.ResumeResponseDto;

public interface ResumeService {

    ResumeResponseDto getResume(ResumeRequestDto resumeRequestDto);

}
