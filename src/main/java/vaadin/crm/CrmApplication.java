package vaadin.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vaadin.crm.backend.jpa.pojos.Address;
import vaadin.crm.backend.jpa.pojos.Gender;
import vaadin.crm.backend.jpa.pojos.School;
import vaadin.crm.backend.jpa.pojos.Student;
import vaadin.crm.backend.jpa.services.SchoolService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CrmApplication {
	@Autowired
	private SchoolService schoolService;

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	@PostConstruct
	public void init(){
		var address1 = new Address("Kyrgyzstan", "Talas", "Sovetskaya", "94");
		var school1 = new School("School #1", address1);

		var student1 = new Student("Stas", null, "Wong", 10, Gender.MALE);
		var student2 = new Student("Iolanda", null, "Wong", 7, Gender.FEMALE);
		school1.addStudent(student1, student2);

	}

}
