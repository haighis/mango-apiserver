package com.mango.api.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityConstants {

	public static final String SECRET="aek@225&.net";
	public static final long EXPIRATION_TIME= 864_000_000;
	public static final String TOKEN_PREFIXE="Bearer ";

}
