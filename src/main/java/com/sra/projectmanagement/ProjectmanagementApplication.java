package com.sra.projectmanagement;
import com.sra.projectmanagement.logic.RiskRegisterDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		ProjectmanagementApplication.class,
		Jsr310JpaConverters.class
})
public class ProjectmanagementApplication {

	private static final Logger LOG = LoggerFactory.getLogger("JCG");

	@Autowired
	private RiskRegisterDelegate riskRegisterDelegate;

	@PostConstruct
	void init() {
		TimeZone.getDefault();
	}

	public static void main(String[] args) {

		SpringApplication.run(ProjectmanagementApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
	RiskRegister risk = riskRegisterDelegate.createRisk(new RiskRegister());
		LOG.info("Risk created in DB : {}", risk);


	}*/
}
