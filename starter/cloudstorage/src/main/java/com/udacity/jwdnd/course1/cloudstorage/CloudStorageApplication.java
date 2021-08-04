package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CloudStorageApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	@Override
	public void run(String... args) throws Exception {

//		logger.info("Insert into database this -> {}", userMapper.insertOne(new Users(1, "random", "name")));
//		logger.info("Insert into database this -> {}", userMapper.insertTwo(new Users(2, "sanders", "bleh")));
//
//		logger.info("Show from database this -> {}", userMapper.findById(1));
//		logger.info("Show from database this -> {}", userMapper.findById(2));

//		logger.info("Insert into database this -> {}", userMapper.insertOne(new Users(3, "rty", "ytre")));
//		logger.info("Insert into database this -> {}", userMapper.insertTwo(new Users(4, "xcvb", "nbvc")));

		logger.info("Select -> {}", userMapper.findAll());
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudStorageApplication.class, args);
	}
}