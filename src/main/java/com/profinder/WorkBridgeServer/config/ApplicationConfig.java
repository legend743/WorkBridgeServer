package com.profinder.WorkBridgeServer.config;
//
//
//import com.profinder.WorkBridgeServer.repository.UserInfoRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@Configuration
//@RequiredArgsConstructor
//public class ApplicationConfig  {
//    private  final UserInfoRepository userInfoRepository;
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return username ->
//            userInfoRepository.findByEmail(username).
//                    orElseThrow(
//                            ()->new UsernameNotFoundException("User name not found"));
//
//}


//}