package com.larrex.large.notification.serviceimpl;

import com.larrex.large.exception.NotFoundExceptionHandler;
import com.larrex.large.notification.entity.Notification;
import com.larrex.large.notification.repository.NotificationRepository;
import com.larrex.large.notification.service.NotificationService;
import com.larrex.large.user.entity.User;
import com.larrex.large.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Override
    public void createNotification(Notification notification) throws NotFoundExceptionHandler {

        notificationRepository.save(notification);
        User user = userRepository.findById(notification.getAuthorId()).orElseThrow(() -> new NotFoundExceptionHandler("No user fount with id " + notification.getAuthorId()));

        if (user.getNotificationList() == null) {

            List<Notification> notificationList = new ArrayList<>();
            notificationList.add(notification);

            user.setNotificationList(notificationList);

        }else {

            if (user.getNotificationList().size() <= 24){
                user.getNotificationList().add(notification);
            }else {
                user.getNotificationList().remove(24);
                user.getNotificationList().add(notification);
            }

        }

        userRepository.save(user);

    }

}
