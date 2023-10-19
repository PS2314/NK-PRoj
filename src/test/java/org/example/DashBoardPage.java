package org.example;

import java.sql.Array;
import java.util.Random;

public class DashBoardPage {

public String fakeName(){
   String[] first_names = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack", "Katie", "Liam", "Mia", "Noah", "Olivia", "Paul", "Quinn", "Ryan", "Sophia", "Tom", "Uma", "Victor", "Willow", "Xander", "Yara", "Zane"};
    String[] last_names = {"Smith", "Johnson", "Brown", "Davis", "Wilson", "Lee", "Anderson", "Wright", "Harris", "Martin", "White", "Walker", "Hall", "Young", "Allen", "King", "Wright", "Evans", "Hill", "Adams"};

    Random random = new Random();
    String Fake_name= first_names +" "+ last_names;
    return Fake_name;
}
}