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

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import jwt.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/rest/**"); // This filter will be hit for every URL as /** is
        // given here
    }

    // validate the request here and use the tokens here
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
        throws AuthenticationException, IOException, ServletException {

        // getting the header from the request under the header name as
        // Authorization
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Token ")) {
            throw new RuntimeException("JWT token is missing");
        }

        // string after "Token " in the header
        String authenticationToken = header.substring(6);

        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);

        return getAuthenticationManager().authenticate(token);
    }

    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
        final FilterChain chain, final Authentication authResult) throws IOException, ServletException {

        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response); // proceed to our created filter
                                           // once done with the default spring
                                           // ones
    }


}
