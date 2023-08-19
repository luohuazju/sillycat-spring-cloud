package com.sillycat.webfluxlatency.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class VaultConfig extends AbstractVaultConfiguration {
	
	@Value("${vault.host}")
	private String vaultHost;

	@Value("${vault.token}")
	private String vaultToken;

	@Override
	public VaultEndpoint vaultEndpoint() {
		log.info("vault information host: " + vaultHost);
		return VaultEndpoint.create(vaultHost, 443);
	}

	@Override
	public ClientAuthentication clientAuthentication() {
		log.info("vault information token: " + vaultToken.substring(0, 5));
		return new TokenAuthentication(vaultToken);
	}

}
