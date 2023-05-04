package com.charles.dousheng.common.crypto;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTException;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author charles
 * @date 5/1/2023 10:34 PM
 */
public class JwtProcessor {
    // JWT签名密钥，可以根据实际情况进行修改
    private static final String SECRET = "douyinUserInfo";

    /**
     * 生成JWT
     *
     * @param username 用户名
     * @param password 密码
     * @return JWT字符串
     */
    public static String createJwt(Long userId, String username, String password) {
        DateTime now = DateTime.now();
        DateTime expiresTime = now.offsetNew(DateField.HOUR, 24);

        Map<String,Object> payload = new HashMap<>();
        payload.put(JWTPayload.ISSUED_AT, now);
        payload.put(JWTPayload.EXPIRES_AT, expiresTime);
        payload.put(JWTPayload.NOT_BEFORE, now);
        payload.put("userId", userId);
        payload.put("username", username);
        payload.put("password", password);
        return JWTUtil.createToken(payload, SECRET.getBytes());
    }

    /**
     * 解析JWT
     *
     * @param token 令牌
     * @return 是否有效
     * @throws JWTException 如果解析JWT失败抛出该异常
     */
    public static Object parseJwt(String token) throws JWTException {
        JWT jwt = JWTUtil.parseToken(token);
        boolean verifyKey = jwt.setKey(SECRET.getBytes()).verify();
        boolean verifyTime = jwt.validate(0);
        if (verifyKey & verifyTime)
            return null;
        return jwt.getPayload("userId");
    }

}
