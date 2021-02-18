package com.example.oauthwithjdbc.entity;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Entity(name = "oauth_client_details")
//@NoArgsConstructor
public class Clients implements ClientDetails, Serializable {

        @Id
    private String clientId;
    private String clientSecret;
    private String registeredRedirectUri;
    private String scope;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private String resourceIds;
    private String authorizedGrantTypes;
    private String autoapprove;

    public Clients(String clientId, String clientSecret, String scope, Integer accessTokenValiditySeconds, Integer refreshTokenValiditySeconds, String authorizedGrantTypes) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }



    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return Stream.of(this.resourceIds).collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override  //done
    public Set<String> getScope() {
        return Stream.of(this.scope).collect(Collectors.toSet());
    }

    @Override   //done
    public Set<String> getAuthorizedGrantTypes() {
        return Stream.of(this.authorizedGrantTypes).collect(Collectors.toSet());
    }

    @Override //done
    public Set<String> getRegisteredRedirectUri() {
        return Stream.of(this.registeredRedirectUri).collect(Collectors.toSet());
    }

    @Override  //done
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override  //done
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    @Override //done
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    @Override //done
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override //done
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", scope='" + scope + '\'' +
                ", accessTokenValiditySeconds=" + accessTokenValiditySeconds +
                ", refreshTokenValiditySeconds=" + refreshTokenValiditySeconds +
                '}';
    }
}