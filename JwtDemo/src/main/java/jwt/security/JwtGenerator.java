/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package jwt.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jwt.model.JwtUser;

@Component
public class JwtGenerator {

    /**
     * <p>
     * <b> TODO : Insert description of the method's responsibility/role. </b>
     * </p>
     *
     * @param jwtUser
     */
    public String generate(final JwtUser jwtUser) {

        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "mysecret").compact();
    }

}
