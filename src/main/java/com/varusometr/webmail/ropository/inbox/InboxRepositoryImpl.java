package com.varusometr.webmail.ropository.inbox;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:db.properties")
public class InboxRepositoryImpl {
}
