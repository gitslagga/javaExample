package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EnumUsage {
    public static void main(String[] args) {
        for (Size s : Size.values())
            System.out.println(s);

        System.out.println("EnumTest.FRI 的 value = " + Size.FRI.getValue());

        Set<String> s = new HashSet<>();
        s.add("slagga");
        s.add("slagga");
        System.out.println(s.toString());

        Map<String, String> m = new HashMap<>();
        m.put("name", "slagga");
        m.put("name", "slagga");
        System.out.println(m.toString());
    }
}

enum Size {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6) {
        @Override
        public boolean isRest() {
            return true;
        }
    },
    SUN(0) {
        @Override
        public boolean isRest() {
            return true;
        }
    };

    private int value;

    private Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest() {
        return false;
    }
}