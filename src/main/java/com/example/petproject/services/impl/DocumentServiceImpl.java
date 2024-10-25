package com.example.petproject.services.impl;

import com.example.petproject.dtos.Document;
import com.example.petproject.dtos.DocumentResponseDto;
import com.example.petproject.repositories.DocumentRepository;
import com.example.petproject.services.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentResponseDto getAllDocuments() {
        return DocumentResponseDto.builder().documents(documentRepository.findAll().stream()
                .map(it -> Document.builder()
                        .id(it.getId())
                        .name(it.getName())
                        .content(it.getContent())
                        .build())
                .collect(Collectors.toList())).build();
    }
}
