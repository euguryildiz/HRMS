package UgurYildiz.Hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="job_advertisements ")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private Number minSalary;

    @Column(name = "max_salary")
    private Number maxSalary;

    @Column(name = "open_position_count")
    private  int openPositionCount;

    @Column(name = "is_active")
    private  boolean isActive;

    @Column(name = "last_date")
    private Date lastDate;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id")
    private City city;

}
