import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "name")
    private String name;



    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;
   public City() {

   }
    public City(int cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

    public City( String name, List<Employee> employees) {

        this.name = name;
        this.employees = employees;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "город " +
                "id = " + cityId + " " +
                 name + " " + ", количество сотрудников: " + employees.size();
    }


}
