package com.turingoal.cms.core.commons;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.turingoal.common.util.io.PropsUtil;

/**
 * 使用spring的bcrypt
 */
public final class TgSecurityPasswordHelper {
    private static int strength = Integer.valueOf(PropsUtil.getValue("security.passwordEncoderStrength", "application.properties"));

    private TgSecurityPasswordHelper() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 将输入的密码进行特殊处理，防止密码轻易被破解
     */
    public static String encodePassword(final String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
        return passwordEncoder.encode(password);
    }

    /**
     * 判断输入的密码是否与应用中存储的密码相符合。因为应用中存储的密码是由输入的密码经过特殊处理后生成的， 所以需要我们自己定义如何判断输入的密码和存储的密码的一致性
     */
    public static boolean isPasswordValid(final String encPass, final String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
        return passwordEncoder.matches(password, encPass);
    }

    /**
     * 测试
     */
    public static void main(final String[] args) {
        System.out.println(encodePassword("test"));
        String pass = "000000";
        String enpass = "$2a$11$zyvrkb4U5/.OWFEDtJgMlOGRmCy7UrI.zFOezjxRZ1o1qJdRA6MR6";
        System.err.println(isPasswordValid(enpass, pass));
    }
}
