package com.pe.criticalOne.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceService {
    Random r = new Random();
    public String roll(int d4, int d6, int d8, int d10, int d12, int d20, int bonus) {
        int result = 0;
        String message = "";
        if (d4 != 0) {
            for (int i = 0; i < d4; i++) {
                result += r.nextInt(4) + 1;;
            }
        }
        if (d6 != 0) {
            for (int i = 0; i < d6; i++) {
                result += r.nextInt(6) + 1;
            }
        }
        if (d8 != 0) {
            for (int i = 0; i < d8; i++) {
                result += r.nextInt(8) + 1;
            }
        }
        if (d10 != 0) {
            for (int i = 0; i < d10; i++) {
                result += r.nextInt(10) + 1;
            }
        }
        if (d12 != 0) {
            for (int i = 0; i < d12; i++) {
                result += r.nextInt(12) + 1;
            }
        }
        if (d20 != 0) {
            for (int i = 0; i < d20; i++) {
                int temp = r.nextInt(20) + 1;
                if (temp == 20) {
                    message += "+";
                } else if (temp == 1) {
                    message += "-";
                }
                result += temp;
            }
        }
        result += bonus;

        return result + message;
    }
}
