//package com.ranthari.app.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ranthari.app.jwt.config.JwtTokenUtil;
//import com.ranthari.app.jwt.service.JwtUserDetailsService;
//import com.ranthari.app.model.JwtResponse;
//import com.ranthari.app.model.LoginRequest;
//
//import io.jsonwebtoken.impl.DefaultClaims;
//
//@RestController
//@CrossOrigin
//public class AuthenticationController {
//
//	@Autowired
//	AuthenticationManager authManager;
//
//	@Autowired
//	private JwtTokenUtil jwtUtil;
//
//	@Autowired
//	private JwtUserDetailsService userDetailsService;
//
//	@PostMapping("/authenticate")
//	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) throws Exception {
//		authenticate(request.getUsername(), request.getPassword());
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//		final String token = jwtUtil.generateToken(userDetails);
//		return ResponseEntity.ok(new JwtResponse(token));
//	}
//
//	private void authenticate(String username, String password) throws Exception {
//
//		try {
//			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//
//	}
//	
//	@GetMapping("/refreshToken")
//	public ResponseEntity<?>  refreshToken(HttpServletRequest request) {
//		DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");
//		Map<String, Object> expectedMap = getMapFromIOJWTClaims(claims);
//		String token = jwtUtil.doRefreshToken(expectedMap, expectedMap.get("sub").toString());
//		return ResponseEntity.ok(new JwtResponse(token));
//	}
//
//	private Map<String, Object> getMapFromIOJWTClaims(DefaultClaims claims) {
//		Map<String, Object> expectedMap = new HashMap<>();
//		for (Entry<String, Object> entry : claims.entrySet()) {
//			expectedMap.put(entry.getKey(), entry.getValue());
//		}
//		return expectedMap;
//	}
//
//}
