package com.neuedu.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.neuedu.entity.Teacher;

/**
 * @author 施子安
 * @create
 */
public class JwtUtil {
    private static final String KEY = "shizian";
    //token到期时间60s
    private static final long EXPIRE_TIME= 60*100000;
    public static String getToken(Teacher teacher){

        String sign = JWT.create()
                .withClaim("tel", teacher.getTel())
                .withClaim("id", teacher.getId())
                .sign(Algorithm.HMAC256(KEY));
        return sign;
    }
    public static Teacher decode(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(KEY)).build().verify(token);
        String tel = verify.getClaim("tel").asString();
        Integer id = verify.getClaim("id").asInt();

        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setTel(tel);

        return teacher;
    }
}
