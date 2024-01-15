package com.larrex.large.notification.service;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.notification.entity.Notification;

public interface NotificationService {

   void createNotification(Notification notification) throws NotFoundExceptionHandler;

}
