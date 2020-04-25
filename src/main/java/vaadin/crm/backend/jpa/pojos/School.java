package vaadin.crm.backend.jpa.pojos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//@Entity
public class School extends AbstractEntity {
    private Logger logger = LoggerFactory.getLogger(School.class);

    protected String name;
    //@OneToOne
    protected Address address;

    protected Set<Student> students = new HashSet<>();

    public School() {
        super();
    }

    public School(@NotNull String name, @NotNull Address address) {
        super();
        this.name = name;
        this.address = address;
    }

    /**
     * update student by id.
     * @return updated Student object.
     */
    public Student updateStudent(long id, String firstName, String middleName, String lastName, int age, Gender gender) {
        var student = getStudent(id);
        var studentOld = student;
        if (age != 0)
            student.setAge(age);
        if (firstName != null && !firstName.equals(""))
            student.setFirstName(firstName);
        if (middleName != null && !middleName.equals(""))
            student.setMiddleName(middleName);
        if (lastName != null && !lastName.equals(""))
            student.setLastName(lastName);
        if (gender != null)
            student.setGender(gender);

        deleteStudent(id);
        addStudent(student);
        logger.info("Update student. Old data: "+studentOld.toString()+". New data: "+student.toString());
        return student;
    }

    /**
     * @param students varargs of Student.
     */
    public void addStudent(Student... students) {
        this.students.addAll(Arrays.asList(students));
        for (Student s : students) {
            logger.info("added new student: " + s.toString() + " to school: " + this.toString());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        logger.info("added new student: " + student.toString() + " to school: " + this.toString());
    }

    public void addStudent(String firstName, String lastName, int age, Gender gender) {
        var student = new Student(firstName, null, lastName, age, gender);
        students.add(student);
        logger.info("added new student: " + student.toString() + " to school: " + this.toString());
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public boolean hasStudent(long id) {
        for (Student s : students) {
            if (s.getId() == id)
                return true;
        }
        return false;
    }

    public Student getStudent(long id) {
        for (Student student : students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public boolean deleteStudent(long id) {
        var student = getStudent(id);
        var deleted = students.removeIf(s -> s.getId() == id);
        if (deleted)
            logger.warn("deleted student: " + student.toString());
        else
            logger.debug("delete student: " + student.toString() + " failed");
        return deleted;
    }

    public void deleteStudent(long... ids) {
        for (long id : ids) {
            deleteStudent(id);
        }
    }

    public int countOfStudents() {
        return students.size();
    }

    /**
     * @param fullName example: "Stanislav Wong"
     * @return Empty set if no any with given name. Set with 1 entry if only 1 exist.
     * Set with many entries if found more that 1.
     */
    public Set<Student> getStudent(String fullName) {
        Set<Student> searchResult = new HashSet<>();
        for (Student student : students) {
            if (student.getFullName().equals(fullName))
                searchResult.add(student);
        }
        return searchResult;
    }

    //region getters/setters
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //endregion

    //region equals/hasCode/toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        if (!super.equals(o)) return false;
        School school = (School) o;
        return getName().equals(school.getName()) &&
                getAddress().equals(school.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getAddress());
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address=" + address.toString() +
                ", id=" + id +
                '}';
    }
    //endregion
}
