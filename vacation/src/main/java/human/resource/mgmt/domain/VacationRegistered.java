package human.resource.mgmt.domain;

import human.resource.mgmt.domain.*;
import human.resource.mgmt.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VacationRegistered extends AbstractEvent {

    private String id;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String userId;
    private Integer days;

    public VacationRegistered(Vacation aggregate) {
        super(aggregate);
    }

    public VacationRegistered() {
        super();
    }
}
