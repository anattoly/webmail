package com.varusometr.webmail.ropository.user;

import com.varusometr.webmail.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
@PropertySource("db.properties")
public class UserRepositoryImpl implements UserRepository {

    @Value("${User.createUser}")
    private String qCreateUser;

    @Value("${User.updateUser}")
    private String qUpdateUser;

    @Value("${User.deleteUser}")
    private String qDeleteUser;

    @Value("${User.findById}")
    private String qfindById;

    @Value("${User.findByUsername}")
    private String qfindByUsername;

    @Value("${User.findAll}")
    private String qfindAll;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createUser(User user) {
        jdbcTemplate.update(qCreateUser,
                user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName());
    }

    @Override
    public void removeUserById(Long id) {
        jdbcTemplate.update(qDeleteUser, id);
    }

    @Override
    public void updateUserById(Long id, User user) {
        jdbcTemplate.update(qUpdateUser,
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName());
    }

    @Override
    public User findUserById(Long id) {
        return jdbcTemplate.queryForObject(qfindById, new Object[]{id}, new UserMapper());
    }

    @Override
    public User findByUsername(String username) {
        return jdbcTemplate.queryForObject(qfindByUsername, new Object[]{username}, new UserMapper());
    }

    @Override
    public Page<User> findAll(int page, int size) {
        List<User> userList = new LinkedList<>(jdbcTemplate.query(qfindAll, new UserMapper()));

        long countUser = userList.size();
        Pageable rowToPage = PageRequest.of(page, size);
        int start = (int) rowToPage.getOffset();
        int end = (start + rowToPage.getPageSize()) > countUser ? (int) countUser : (start + rowToPage.getPageSize());

        return new PageImpl<>(userList.subList(start, end), rowToPage, countUser);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(jdbcTemplate.query(qfindAll, new UserMapper()));
    }
}
