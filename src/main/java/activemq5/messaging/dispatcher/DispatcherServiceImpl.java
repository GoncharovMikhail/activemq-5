package activemq5.messaging.dispatcher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DispatcherServiceImpl implements DispatcherService {
    private final JmsTemplate jmsTemplate;
    private final String queueName;

    @Autowired
    public DispatcherServiceImpl(JmsTemplate jmsTemplate, @Value("${jms.queue.name}") String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    public void sendMsg(String msg) {
        jmsTemplate.convertAndSend(queueName, msg);
    }
}
