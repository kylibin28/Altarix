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

    @Column(name = "departament_name", length = 100, nullable = false, unique = true)
    private String departament_name;

    @Column(name = "creation_date", nullable = false)
    private Date creation_date;

    @Column(name = "name_main_department")
    private String NameMainDepartment;

    @OneToMany(mappedBy = "departament")
    private Set<Employee> employees = new HashSet<Employee>();

//    @OneToOne()
//    @JoinColumn(name = "employee")
//    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Employee chiefEmployee;

    public Department(){}

    public void setId_department(Integer id_department) {
        this.id_department = id_department;
    }

    public void setDepartament_name(String departament_name) {
        this.departament_name = departament_name;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setNameMainDepartment(String nameMainDepartment) {
        NameMainDepartment = nameMainDepartment;
    }

    public Department(String departament_name, Date creation_date, String NameMainDepartment) {
        this.departament_name = departament_name;
        this.creation_date = creation_date;
        this.NameMainDepartment = NameMainDepartment;
    }

    public Integer getId_department() {
        return id_department;
    }

    public String getDepartament_name() {
        return departament_name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public Employee getChiefEmployee() {
        return chiefEmployee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id_department=" + id_department +
                ", departament_name='" + departament_name + '\'' +
                ", creation_date=" + creation_date +
                ", NameMainDepartment='" + NameMainDepartment + '\'' +
                '}';
    }
}

