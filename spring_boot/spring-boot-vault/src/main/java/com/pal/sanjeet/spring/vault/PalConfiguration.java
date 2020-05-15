package com.pal.sanjeet.spring.vault;

import org.springframework.boot.context.properties.ConfigurationProperties;











/*
vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"
export export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
export VAULT_ADDR="http://127.0.0.1:8200"


vault kv put secret/gs-vault-config sanjeet.username=user sanjeet.password=password12345
vault kv get secret/gs-vault-config
vault kv delete secret/gs-vault-config
*/
@ConfigurationProperties("sanjeet")
public class PalConfiguration {

  private String username;

  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
