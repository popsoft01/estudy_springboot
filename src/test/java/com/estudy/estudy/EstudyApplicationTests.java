package com.estudy.estudy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
@SpringBootTest
class EstudyApplicationTests {
	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {



			assertThat(dataSource).isNotNull();
//        assertThat(dataSource).isNull();
			log.info("Product before saving -> {}", dataSource);
			try{
				Connection connection = dataSource.getConnection();
				assertThat(connection).isNotNull();
				log.info("huger ->{}", connection.getCatalog());


			}catch (SQLException exception){
				log.info("huger ->{}", exception.getMessage());

			}

		}


}
