package com.larrex.large.notification.event;

import com.larrex.large.notification.entity.Notification;
import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent {

    private String notificationToId;
    private Notification notification;

    public NotificationEvent(Object source,String notificationToId,Notification notification) {
        super(source);
        this.notificationToId = notificationToId;
        this.notification = notification;
    }

    public String getNotificationToId() {
        return notificationToId;
    }

    public Notification getNotification() {
        return notification;
    }
}
