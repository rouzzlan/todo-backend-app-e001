package com.falcontech.authtodo.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class UserIdentifier {
  private final static String PREFIX = "Bearer ";
  private final static String JWT_EMAIL = "email";
  private final static String JWT_SUB = "sub";
  private final static String JWT_NAME = "name";


  public String getClaimsFromToken(String authorization) {
    String jwtToken = authorization.replace(PREFIX, "");
    String[] chunks = jwtToken.split("\\.");
    Base64.Decoder decoder = Base64.getUrlDecoder();
    return new String(decoder.decode(chunks[1]));
  }

  @SneakyThrows
  public JwtUserInfo getUserInfo(String authorizationHeaderValue) {
    String jsonData = getClaimsFromToken(authorizationHeaderValue);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(jsonData);
    String name = node.get(JWT_NAME).asText();
    String sub = node.get(JWT_SUB).asText();
    String email = node.get(JWT_EMAIL).asText();
    return JwtUserInfo.builder().uid(sub).email(email).name(name).build();
  }
}
