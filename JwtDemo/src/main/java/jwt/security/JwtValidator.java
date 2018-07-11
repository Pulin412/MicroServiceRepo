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
import jwt.model.JwtUser;

@Component
public class JwtValidator {

    private String secret = "mysecret";

    public JwtUser validate(final String token) {

        // secret with which the token will be checked/validated, parsed for
        // the value and body is returned of the token
        JwtUser jwtUser = null;
        try {
            Claims body = (Claims) Jwts.parser().setSigningKey(this.secret).parse(token).getBody();
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }


}
