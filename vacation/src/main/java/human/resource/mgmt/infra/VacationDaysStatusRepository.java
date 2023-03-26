package human.resource.mgmt.infra;

import human.resource.mgmt.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "vacationDaysStatuses",
    path = "vacationDaysStatuses"
)
public interface VacationDaysStatusRepository
    extends PagingAndSortingRepository<VacationDaysStatus, Long> {}
