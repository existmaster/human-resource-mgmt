package human.resource.mgmt.external;

import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService {

    /**
     * Fallback
     */
    public Calendar getCalendar(Long id) {
        Calendar calendar = new Calendar();
        return calendar;
    }
}
