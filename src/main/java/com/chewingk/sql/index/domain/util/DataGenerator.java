package com.chewingk.sql.index.domain.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DataGenerator {
    private static final Random RANDOM = new Random();
    private static final String[] statuses = {
        "active", "inactive", "terminated", "on_leave",
        "retired", "probation", "contract", "intern",
        "sabbatical", "consultant"};

    public static char generateGender() {
        return RANDOM.nextBoolean() ? 'M' : 'F';
    }

    public static BigDecimal generateSalary() {
        return BigDecimal.valueOf(30000 + (150000 - 30000) * RANDOM.nextDouble());
    }

    public static String generateStatus() {
        return statuses[RANDOM.nextInt(statuses.length)];
    }

    // 生成6位数字的邮编
    public static String generateZipCode() {
        int zipCode = 100000 + RANDOM.nextInt(900000);
        return String.valueOf(zipCode);
    }

    // 生成以1开头的11位数字手机号码
    public static String generatePhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("1");
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(RANDOM.nextInt(10));
        }
        return phoneNumber.toString();
    }

    // 生成包含特定日期的18位数字身份证号码
    public static String generateIdNumber(java.sql.Date birthDate) {
        StringBuilder idNumber = new StringBuilder();

        // 前6位数字随便生成一个地区码
        idNumber.append(100000 + RANDOM.nextInt(900000));

        // 第7到第14位是出生日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String birthDateString = sdf.format(birthDate);
        idNumber.append(birthDateString);

        // 第15到第17位数字
        idNumber.append(String.format("%03d", RANDOM.nextInt(1000)));

        // 第18位是校验位
        idNumber.append(calculateCheckDigit(idNumber.toString()));

        return idNumber.toString();
    }

    // 根据前17位计算身份证号码的校验位
    private static char calculateCheckDigit(String idNumber) {
        int[] weights = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] checkDigits = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += (idNumber.charAt(i) - '0') * weights[i];
        }
        return checkDigits[sum % 11];
    }
}
