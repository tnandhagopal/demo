package com.example.demo.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository proRepo;

	public List<Project> getAll() {

		List<Project> retList = new ArrayList<Project>();

		proRepo.findAll().forEach(retList::add);

		return retList;
	}

}
