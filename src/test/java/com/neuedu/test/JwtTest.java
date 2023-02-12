package com.neuedu.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author 施子安
 * @create
 */
public class JwtTest {
    static final  String KET ="shizian";
    public static void main(String[] args) {
        /*String s = JWT.create()
                .withClaim("name", "张三")
                .withClaim("id", 1)
                .sign(Algorithm.HMAC256(KET));
        System.out.println(s);*/
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5byg5LiJIiwiaWQiOjF9.GLnVWOLxK4eanFTV6o18lR-5I68-Y0252FoYmy7JT3s";
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(token))
//                .build();
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(KET)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String name = decodedJWT.getClaim("name").asString();
        Integer id = decodedJWT.getClaim("id").asInt();
        System.out.println(id);
        System.out.println(name);
    }
}
