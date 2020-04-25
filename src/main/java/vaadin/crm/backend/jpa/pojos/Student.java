package vaadin.crm.backend.jpa.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

//@Entity(name = "students")
public class Student extends AbstractEntity {
    //@Column(nullable = false)
    protected String fullName;
    //@Column(nullable = false)
    protected String firstName;
    //@Column
    protected String middleName;
    //@Column(nullable = false)
    protected String lastName;
    //@Column(nullable = false)
    protected int age;
    //@Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    protected Gender gender;

    public Student() {
        super();
    }

    /**
     * full name assembled automatically after enter at least first and last name.
     */
    public Student(String firstName, String middleName, String lastName, int age, Gender gender) {
        super();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        if (middleName != null)
            fullName = String.format("%s %s %s", firstName, middleName, lastName);
        else
            fullName = String.format("%s %s", firstName, lastName);
    }

    //<editor-fold desc="getters/setters">
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                getFullName().equals(student.getFullName()) &&
                getFirstName().equals(student.getFirstName()) &&
                Objects.equals(getMiddleName(), student.getMiddleName()) &&
                getLastName().equals(student.getLastName()) &&
                getGender() == student.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFullName(), getFirstName(), getMiddleName(), getLastName(), getAge(), getGender());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender.name() +
                '}';
    }
}
