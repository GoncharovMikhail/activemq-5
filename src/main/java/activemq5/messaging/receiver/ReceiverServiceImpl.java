package activemq5.messaging.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiverServiceImpl implements ReceiverService {
    @JmsListener(destination = "${jms.queue.name}")
    public void receiveMsg(String msg) {
        log.info("Msg: {}", msg);
    }
}
