package departmentProgram.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Макс on 11.10.2017.
 */
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_department")
    private Integer id_department;

    @Column(name = "department_name", length = 100, nullable = false, unique = true)
    private String department_name;

    @Column(name = "creation_date", nullable = false)
    private Date creation_date;

    @Column(name = "name_main_department")
    private String nameMainDepartment;

    @OneToMany(mappedBy = "id_department")
    private Set<Employee> employees = new HashSet<Employee>();

    @OneToOne()
    @JoinColumn(name = "chief_employee")
    private Employee chief_employee;

//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Employee chiefEmployee;

    public Department(){}

    public Department(String departament_name, Date creation_date, String nameMainDepartment) {
        this.department_name = departament_name;
        this.creation_date = creation_date;
        this.nameMainDepartment = nameMainDepartment;
    }

    public Employee getChief_employee() {
        return chief_employee;
    }

    public void setChief_employee(Employee chief_employee) {
        this.chief_employee = chief_employee;
    }

    public void setId_department(Integer id_department) {
        this.id_department = id_department;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setNameMainDepartment(String nameMainDepartment) {
        nameMainDepartment = nameMainDepartment;
    }

    public Integer getId_department() {
        return id_department;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public Employee getChiefEmployee() {
        return chief_employee;
    }

    public String getNameMainDepartment() {
        return nameMainDepartment;
    }

    @Override
    public String toString() {

        if(chief_employee != null && employees != null)
        return "Department{" +
                "id_department=" + id_department +
                ", department_name='" + department_name + '\'' +
                ", creation_date=" + creation_date +
                ", NameMainDepartment='" + nameMainDepartment + '\'' +
                ", chief: surname=" + chief_employee.getSurname() + " name=" + chief_employee.getName() +
                ", count_employees='" + employees.size() +
                '}';
        else return "Department{" +
                "id_department=" + id_department +
                ", department_name='" + department_name + '\'' +
                ", creation_date=" + creation_date +
                ", NameMainDepartment='" + nameMainDepartment + '\'' +
                ", chief: surname= null" +
                ", count_employees= null" +
                '}';
    }
}

