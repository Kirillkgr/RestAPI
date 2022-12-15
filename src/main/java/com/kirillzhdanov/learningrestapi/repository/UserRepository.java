package com.kirillzhdanov.learningrestapi.repository;

import com.kirillzhdanov.learningrestapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findBylogin(String login);
     List<User> findAll();
    static List<User> getUsersList(UserRepository  userRepository) {
        List<User> ListAllData = userRepository.findAll();
        List<User> ReverseListAllData = new ArrayList<>();
        ListIterator<User> itr = ListAllData.listIterator(ListAllData.size());
        ReverseListAllData.clear();
        while (itr.hasPrevious()) {
            ReverseListAllData.add(itr.previous());
        }
        ListAllData.clear();
        return ReverseListAllData;
    }
}
