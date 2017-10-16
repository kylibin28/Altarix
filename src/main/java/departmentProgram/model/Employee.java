package departmentProgram.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Макс on 11.10.2017.
 */

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee")
    private Integer id_employee;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "patronymic", length = 50)
    private String patronymic;

    @Column(name = "sex", length = 10, nullable = false)
    private String sex;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "admition_date", nullable = false)
    private Date admition_date;

    @Column(name = "dismissal_date")
    private Date dismissal_date;

    @Column(name = "post", length = 50, nullable = false)
    private String post;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "chief", nullable = false)
    private Boolean chief;

    public Integer getId_employee() {
        return id_employee;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department")
    private Department id_department;

    @OneToOne(mappedBy = "chief_employee")
    private Department chief_employee;

    public Employee(){}

    public Employee(String surname, String name,  String patronymic, String sex,
                    Date birthday, Date admition_date, Date dismissal_date,
                    String post, Integer salary, Boolean chief, Department id_department) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.birthday = birthday;
        this.admition_date = admition_date;
        this.dismissal_date = dismissal_date;
        this.post = post;
        this.salary = salary;
        this.chief = chief;
        this.id_department = id_department;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getAdmition_date() {
        return admition_date;
    }

    public Date getDismissal_date() {
        return dismissal_date;
    }

    public String getPost() {
        return post;
    }

    public Integer getSalary() {
        return salary;
    }

    public Boolean getChief() {
        return chief;
    }

    public Department getDepartament() {
        return id_department;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAdmition_date(Date admition_date) {
        this.admition_date = admition_date;
    }

    public void setDismissal_date(Date dismissal_date) {
        this.dismissal_date = dismissal_date;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setChief(Boolean chief) {
        this.chief = chief;
    }

    public void setDepartament(Department id_department) {
        this.id_department = id_department;
    }

//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", admition_date=" + admition_date +
                ", dismissal_date=" + dismissal_date +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", chief=" + chief +
//                ", chief: surname=" + chief_employee.getSurname() + " name=" + chief_employee.getName() +
                '}';
    }
}
