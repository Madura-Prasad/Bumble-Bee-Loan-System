package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@SpringBootTest
public class UserControlTest {
	@Autowired
	UsersRepository usersRepository;

	@Test
	public void testSaveUsers() {
		Users users = new Users();
		users.setId(1L);
		users.setName("Madura");
		users.setAddress("MainRoad");
		users.setDob("2000-11-12");
		users.setMobile("0783587735");
		users.setPassword("Madura1@");
		usersRepository.save(users);
		assertNotNull(usersRepository.findById(1L).get());
	}

	@Test
	public void testReadAll() {
		List<Users> list = usersRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void testSingleUser() {
		Users users = usersRepository.findById(1L).get();
		assertEquals("MainRoad", users.getAddress());
	}

	@Test
	public void testUpdateUser() {
		Users users = usersRepository.findById(1L).get();
		users.setName("MaduraPrasad");
		usersRepository.save(users);
		assertNotEquals("Madura", usersRepository.findById(1L).get().getName());
	}

	@Test
	public void testDelete() {
		usersRepository.deleteById(2L);
		assertThat(usersRepository.existsById(2L)).isFalse();
	}

}
