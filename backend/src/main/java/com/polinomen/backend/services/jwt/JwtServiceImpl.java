package com.polinomen.backend.services.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl implements IJWTService {
  private final JwtEncoder encoder;

  public JwtServiceImpl(JwtEncoder encoder) {
    this.encoder = encoder;
  }

  public String generateToken(Authentication authentication, String subject) {
    Instant now = Instant.now();
    long expiry = 3600L;
    String scopes = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(" "));
    JwtClaimsSet claims = JwtClaimsSet
        .builder()
        .issuer("polinomen")
        .issuedAt(now)
        .expiresAt(now.plusSeconds(expiry))
        .subject(subject)
        .claim("scope", scopes)
        .build();
    return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }
}