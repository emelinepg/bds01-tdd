package com.devsuperior.bds01.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	@Transactional(readOnly = true)
	public List<DepartmentDTO> findAll() {
		List<Department> list = repository.findAll(Sort.by("name"));
		List<DepartmentDTO> dptDto = new ArrayList<>();
		for (Department dpt : list) {
			DepartmentDTO dto = new DepartmentDTO(dpt);
			dptDto.add(dto);	
		}
		return dptDto;
	}

}
