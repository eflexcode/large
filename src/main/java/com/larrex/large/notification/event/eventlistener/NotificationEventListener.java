package com.larrex.large.notification.event.eventlistener;

import com.larrex.large.notification.event.NotificationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.core.MongoTemplate;

public class NotificationEventListener implements ApplicationListener<NotificationEvent> {
    @Override
    public void onApplicationEvent(NotificationEvent event) {
        MongoTemplate mongoTemplate = new MongoTemplate()
    }
}
