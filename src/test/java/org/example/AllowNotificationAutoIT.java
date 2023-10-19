package org.example;

import java.io.IOException;

public class AllowNotificationAutoIT {
    public void allownoti() {
    try {
        // Execute the AutoIT script
        Runtime.getRuntime().exec("C:\\Users\\DELL\\git\\SeleNTry\\allow.au3");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
