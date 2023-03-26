package human.resource.mgmt.external;

import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl implements VacationService {

    /**
     * Fallback
     */
    public Vacation getVacation(Long id) {
        Vacation vacation = new Vacation();
        return vacation;
    }
}
