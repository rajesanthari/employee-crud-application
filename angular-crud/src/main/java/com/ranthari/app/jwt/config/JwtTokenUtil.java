//package com.ranthari.app.jwt.config;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//@PropertySource("classpath:jwt.properties")
//public class JwtTokenUtil implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2898555452477823365L;
//
//	@Value("${jwt.token.validity:18000}")
//	public long JWT_TOKEN_VALIDITY;
//	
//	@Value("${jwt.refresh.token.validity:1800000}")
//	public long JWT_REFRESH_TOKEN_VALIDITY;
//
//	@Value("${jwt.secret}")
//	public String secret;
//
//	// We need secret to retrieve the info from token
//	private Claims getAllClaimsFromTheToken(String token) {
//		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//	}
//
//	public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
//		final Claims claim = getAllClaimsFromTheToken(token);
//		return claimResolver.apply(claim);
//	}
//
//	public Date getExpirationDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getExpiration);
//	}
//
//	public String getUsernameFromToken(String token) {
//		return getClaimFromToken(token, Claims::getSubject);
//	}
//
//	public boolean isTokenExpired(String token) {
//		final Date expiration = getExpirationDateFromToken(token);
//		return expiration.before(new Date());
//	}
//
//	private String doGenerateToken(Map<String, Object> claims, String subject) {
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
//				.signWith(SignatureAlgorithm.HS512, secret).compact();
//	}
//	public String doRefreshToken(Map<String, Object> claims, String subject) {
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + JWT_REFRESH_TOKEN_VALIDITY))
//				.signWith(SignatureAlgorithm.HS512, secret).compact();
//	}
//
//	public String generateToken(UserDetails userDetails) {
//		return doGenerateToken(new HashMap<>(), userDetails.getUsername());
//	}
//
//	public boolean validateToken(String token, UserDetails userDetails) {
//		final String username = getUsernameFromToken(token);
//		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//	}
//
//}
