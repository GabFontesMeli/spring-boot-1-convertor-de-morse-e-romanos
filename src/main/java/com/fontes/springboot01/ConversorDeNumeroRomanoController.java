package com.fontes.springboot01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertor")

public class ConversorDeNumeroRomanoController {

    @GetMapping("convertormorse/{characters}")
    public String converterMorse(@PathVariable String characters) {
            char[] portuguese = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                    'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                    'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                    ',', '.', '?' };

            String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                    ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                    "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                    "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                    "-----", "--..--", ".-.-.-", "..--.." };

            String userInput = characters.toLowerCase();

            char[] chars = userInput.toCharArray();

            String str = "";
            for (int i = 0; i < chars.length; i++){
                for (int j = 0; j < portuguese.length; j++){

                    if (portuguese[j] == chars[i]){
                        str = str + morse[j] + " ";
                    }
                }
            }
            return characters + ": " + str;
    }

    @GetMapping("/{num}")
    public String converterRomano(@PathVariable int num) {
        int[] vaNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] vaRom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String algarismoRomano = "";
        for (int i = 0; i < vaRom.length; i++) {
            while (num >= vaNum[i]) {
                num -= vaNum[i];
                algarismoRomano += vaRom[i];
            }
        }
        return algarismoRomano;
    }
}
