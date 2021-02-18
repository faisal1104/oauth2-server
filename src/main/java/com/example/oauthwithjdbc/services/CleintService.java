//package com.example.oauthwithjdbc.services;
//
//import com.example.oauthwithjdbc.Repository.ClientsRepository;
//import com.example.oauthwithjdbc.entity.Clients;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.provider.ClientDetails;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.ClientRegistrationException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CleintService implements ClientDetailsService {
//    @Autowired
//    ClientsRepository clientsRepository;
//
//    @Override
//    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
//        System.out.println("Hitttttttttttttttttting.........");
//        Clients c= clientsRepository.findByClientId(s);
//        System.out.println(c);
//        return c;
//    }
//}
