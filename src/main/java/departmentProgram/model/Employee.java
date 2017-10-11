package departmentProgram.model;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departament_name")
    private Department departament_name;

    @OneToOne(mappedBy = "employee")
    private Department department;

    public Employee(){}

    public Employee(String name, String surname, String patronymic, String sex,
                    Date birthday, Date admition_date, Date dismissal_date,
                    String post, Integer salary, Boolean chief, Department departament_name) {
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
        this.departament_name = departament_name;
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

    public Department getDepartament_name() {
        return departament_name;
    }

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
                '}';
    }
}
