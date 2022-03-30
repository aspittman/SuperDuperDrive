package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.services.home.credentials.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.notes.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CloudStorageApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private NoteService noteService;

	@Autowired
	private CredentialService credentialService;

	@Override
	public void run(String... args) throws Exception {

//		logger.info("Insert into database this -> {}", userMapper.insertOne(new Users(1, "random", "name")));
//		logger.info("Insert into database this -> {}", userMapper.insertTwo(new Users(2, "sanders", "bleh")));

		logger.info("Show from database this -> {}", noteService.findNote(132));
//		logger.info("Show from database this -> {}", credentialService.findCredential(93));


//		logger.info("Insert into database this -> {}", userMapper.insertOne(new Users(3, "rty", "ytre")));
//		logger.info("Insert into database this -> {}", userMapper.insertTwo(new Users(4, "xcvb", "nbvc")));
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudStorageApplication.class, args);
	}
}