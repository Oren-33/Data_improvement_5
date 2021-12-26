package com.example.Data_improvement_5.dao;
import com.example.Data_improvement_5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IUserDao extends JpaRepository<User, String> {
    User findUserByIdAndPassword(String id, String name);

    List<User> findUserByAgeGreaterThan(int age);

    @Modifying
    @Transactional
    @Query("update User u set u.")
    int updateUserNameById(@Param("id") String id, @Param("name") String name);

}
