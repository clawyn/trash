package be.bstorm.trash.il.utils;

import be.bstorm.trash.dl.entities.Wizard;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtUtil {

    private final byte[] secret = "yabadabadoooooooooooooooooooooooooooooo".getBytes();
    private final int expireAt = 24 * 60 * 60;
    private final JwtBuilder builder;
    private final JwtParser parser;

    public JwtUtil() {
        this.builder = Jwts.builder().signWith(this.getSecretKey());
        this.parser = Jwts.parserBuilder().setSigningKey(this.getSecretKey()).build();
    }

    private SecretKey getSecretKey() {
        return new SecretKeySpec(secret, "HmacSHA256");
    }

    public String generateToken(Wizard wizard) {
        return this.builder
                .setSubject(wizard.getUsername())
                .claim("id", wizard.getId())
                .claim("role", wizard.getShelterRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireAt * 1000L))
                .compact();
    }

    private Claims getClaims(String token) {
        return this.parser.parseClaimsJws(token).getBody();
    }

    public String getUsername(String token) {
        return this.getClaims(token).getSubject();
    }

    public Long getUserId(String token) {
        return this.getClaims(token).get("id", Long.class);
    }

    public String getRole(String token) {
        return this.getClaims(token).get("role", String.class);
    }

    public boolean isValid(String token) {
        Claims claims = getClaims(token);
        Date now = new Date();
        return now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}