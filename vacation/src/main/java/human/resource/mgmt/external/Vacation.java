package human.resource.mgmt.external;

import java.util.Date;
import lombok.Data;

@Data
public class Vacation {

    private String id;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String userId;
    private Integer days;
    private String status;
}
