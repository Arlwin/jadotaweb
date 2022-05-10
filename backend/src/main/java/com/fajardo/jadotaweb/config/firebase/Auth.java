package com.fajardo.jadotaweb.config.firebase;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Auth {

    // @Value("${spring.cloud.gcp.credentials.encoded-key}")
    // private String serviceAccountJson;

    // private CredentialsProvider credentialsProvider;

    // @Autowired
    // public Auth(CredentialsProvider credentialsProvider){

    //     this.credentialsProvider = credentialsProvider;
    // }

    // @Bean
    // public FirebaseApp firebaseApp() throws IOException {

    //     var options = FirebaseOptions.builder()
    //         .setCredentials(
    //             GoogleCredentials.fromStream(
    //                 new ByteArrayInputStream(
    //                     Base64.getDecoder().decode(serviceAccountJson)
    //                 )
    //             )
    //         )
    //         .build();

    //     return FirebaseApp.initializeApp(options);
    // }
    
    // @Bean
    // public FirebaseAuth firebaseAuth() throws IOException {

    //     return FirebaseAuth.getInstance(firebaseApp());
    // }
}
