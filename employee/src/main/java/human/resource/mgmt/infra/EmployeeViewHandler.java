package human.resource.mgmt.infra;

import human.resource.mgmt.config.kafka.KafkaProcessor;
import human.resource.mgmt.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmployeeViewHandler {

    @Autowired
    private EmployeeRepository employeeRepository;
}
