package com.varusometr.webmail.ropository.inbox;

import com.varusometr.webmail.entity.Inbox;
import com.varusometr.webmail.entity.Mail;
import org.springframework.data.domain.Page;

public interface InboxRepository {
    Page<Inbox> findAllInboxMailByUserId(int page, int size, long userId);

    Mail findInboxMailById(Long mailId, Long userId);

    void removeInboxMailById(Long id);


}
