package vaadin.crm.backend.jpa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vaadin.crm.backend.jpa.pojos.Address;
import vaadin.crm.backend.jpa.pojos.School;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private Logger logger = LoggerFactory.getLogger(School.class);
    private List<School> schools = new ArrayList<>();

    public SchoolService() {
    }

    public void addSchool(School school) {
        schools.add(school);
        logger.info("created new school. name: "+school.getName()+" address: "+school.getAddress().toString());
    }

    public void addSchool(String name, Address address) {
        schools.add(new School(name, address));
        logger.info("created new school. name: "+name+" address: "+address.toString());
    }

    public List<School> getSchools() {
        return schools;
    }

    public Optional<School> getSchool(long id){
        return schools.stream().filter(school -> school.getId() == id).findAny();
    }

    public Optional<School> getSchool(String name){
        return schools.stream().filter(school -> school.getName().equalsIgnoreCase(name)).findAny();
    }
}
