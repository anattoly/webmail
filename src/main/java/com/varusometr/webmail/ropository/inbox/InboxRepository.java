package com.varusometr.webmail.ropository.inbox;

import com.varusometr.webmail.entity.Inbox;
import org.springframework.data.domain.Page;

public interface InboxRepository {
    Page<Inbox> findAllInboxMailByUserId(int page, int size, long userId);

    Inbox findInboxMailById(Long inboxMailId, Long userId);

    void removeInboxMailById(Long inboxMailId);


}
