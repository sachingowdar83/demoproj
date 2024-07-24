package com.sachin.ex.demoproj.service;

import com.sachin.ex.demoproj.entities.DeptEntity;
import com.sachin.ex.demoproj.entities.UserEntity;
import com.sachin.ex.demoproj.repo.DeptRepo;
import com.sachin.ex.demoproj.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Service
public class AccountService {

    @Value("${accounNumer}")
    String acounNumber;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DeptRepo deptRepo;

    public Boolean validateAcc(Integer acc){
      return   Arrays.stream(acounNumber.split(",")).map(a -> a.equals(acc.toString())).findFirst().get();

    }
    @Transactional
    public UserEntity addUser(){
        UserEntity user = UserEntity.builder().name("Sanchu").age(4).build();
        Set<UserEntity> userSet = new HashSet<>();
        userSet.add(user);
       // userRepo.save(user);
        DeptEntity dept = DeptEntity.builder().name("Computer").users(userSet).build();
        deptRepo.save(dept);

        return null;
    }
}
