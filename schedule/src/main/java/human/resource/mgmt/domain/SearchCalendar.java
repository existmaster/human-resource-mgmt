package human.resource.mgmt.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SearchCalendar_table")
@Data
public class SearchCalendar {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
