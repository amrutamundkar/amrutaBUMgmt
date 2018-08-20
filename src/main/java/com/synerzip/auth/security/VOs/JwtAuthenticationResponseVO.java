package com.synerzip.auth.security.VOs;

import java.io.Serializable;

public class JwtAuthenticationResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String token;

    public JwtAuthenticationResponseVO(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
