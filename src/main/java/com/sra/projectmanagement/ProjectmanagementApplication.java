package com.sra.projectmanagement;
import com.sra.projectmanagement.logic.RiskRegisterDelegate;
import com.sra.projectmanagement.model.RiskRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.Calendar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectmanagementApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger("JCG");

	@Autowired
	private RiskRegisterDelegate riskRegisterDelegate;

	public static void main(String[] args) {

		SpringApplication.run(ProjectmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	RiskRegister risk = riskRegisterDelegate.createRisk(new RiskRegister());
		LOG.info("Risk created in DB : {}", risk);


	}
}
