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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import jwt.model.JwtAuthenticationToken;
import jwt.model.JwtUser;
import jwt.model.JwtUserDetails;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator validator;

    // called when there is any user, authentication is the token for which we
    // have created JwtAuthenticationToken
    protected UserDetails retrieveUser(final String username,
        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;

        // get the string token out of this authentication token
        String token = jwtAuthenticationToken.getToken();

        // validate the token if its correct is or not
        JwtUser jwtUser = this.validator.validate(token);
        if (jwtUser == null) {
            throw new RuntimeException("JWT Token is incorrect");
        }

        // fetch the User details in the defined model and also the authorities
        // from the token
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
        return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getId(), token, grantedAuthorities);
    }

    protected void additionalAuthenticationChecks(final UserDetails userDetails,
        final UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    public boolean supports(final Class<?> aClass) {
        // JwtAuthToken will be the model class used by other class for tokens
        return JwtAuthenticationToken.class.isAssignableFrom(aClass);
    }

}
