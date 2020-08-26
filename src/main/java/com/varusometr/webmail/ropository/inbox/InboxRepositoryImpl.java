package com.varusometr.webmail.ropository.inbox;

import com.varusometr.webmail.entity.Inbox;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:db.properties")
public class InboxRepositoryImpl implements InboxRepository{
    @Override
    public Page<Inbox> findAllInboxMailByUserId(int page, int size, long userId) {
        return null;
    }

    @Override
    public Inbox findInboxMailById(Long mailId, Long userId) {
        return null;
    }

    @Override
    public void removeInboxMailById(Long id) {

    }
}
