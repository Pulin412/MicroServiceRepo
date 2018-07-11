/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package jwt.model;

public class JwtUser {

    private String userName;
    private Long id;
    private String role;

    public void setUserName(final String subject) {
        this.userName = subject;
    }

    /**
     * <p>
     * <b> TODO : Insert description of the method's responsibility/role. </b>
     * </p>
     *
     * @param valueOf
     */
    public void setId(final Long valueOf) {
        this.id = valueOf;

    }

    /**
     * <p>
     * <b> TODO : Insert description of the method's responsibility/role. </b>
     * </p>
     *
     * @param string
     */
    public void setRole(final String string) {
        this.role = string;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return this.role;
    }

}
