package edu.integration.patterns.producer;

import org.apache.log4j.Logger;
import org.springframework.context.SmartLifecycle;
import org.springframework.integration.Message;
import org.springframework.integration.core.PollableChannel;

public class ProducerListener implements SmartLifecycle {

    private boolean isRunning;
    private PollableChannel channel;
    private Producer producer;

    private static final Logger logger = Logger.getLogger(ProducerListener.class);

    public ProducerListener(PollableChannel channel, Producer producer) {
        this.channel = channel;
        this.producer = producer;

    }

    @Override
    public void start() {
        isRunning = true;

        Thread messageListener = new Thread() {
            @Override
            public void run() {
                while (isRunning) {
                    logger.info("Waiting for messages");
                    @SuppressWarnings("unchecked")
                    Message<Long> message = (Message<Long>) channel.receive();

                    logger.info("Message received: " + message);

                    producer.buy(message.getPayload());

                    logger.info("Message processed: " + message);

                }
            }
        };

        messageListener.start();
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public void stop(Runnable callback) {
    }

}
