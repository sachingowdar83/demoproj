package com.sachin.ex.demoproj.service;

import com.sachin.ex.demoproj.entities.*;
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
        UserEntity user1 = UserEntity.builder().name("Puttu").age(1).build();

        userSet.add(user);
        userSet.add(user1);
       // userRepo.save(user);
        DeptEntity dept = DeptEntity.builder().name("Computer").users(userSet).build();

        Application app1 = new Application();
        app1.setName("Google");

        Application app2 = new Application();
        app1.setName("Yahoo");

        UserApps userApps = new UserApps();
        userApps.setApps(app1);
        userApps.setUser(user);

        UserApps userApps1 = new UserApps();
        userApps1.setApps(app1);
        userApps1.setUser(user1);

        UserApps userApps2 = new UserApps();
        userApps2.setApps(app2);
        userApps2.setUser(user);

        Laptops laptops = new Laptops();
        laptops.setName("Dell");

            Laptops laptops1 = new Laptops();
        laptops1.setName("Mac");

        user.setUserApps(Arrays.asList(userApps,userApps2));
        user.setLaptop(laptops);

        user1.setLaptop(laptops1);

        user1.setUserApps(Arrays.asList(userApps1));
        user1.setLaptop(laptops);
        userRepo.save(user);
       // userRepo.save(user1);
       // deptRepo.save(dept);

        return null;
    }
}
