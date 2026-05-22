package com.restapi.api.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.User;
import com.restapi.api.services.services;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@CrossOrigin(
   // origins = {"https://front-tesis-nu.vercel.app/", "http://localhost:4200"},
    origins = "https://front-tesis-nu.vercel.app/",
 
   methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET}
)

@RestController
//manejamos las llamadas de la ruta users
@RequestMapping("/users")
public class controller {

      @Autowired
      private services servicesUsers; 

      @Autowired
      private JavaMailSender mailSender;

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private int mailPort;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Value("${spring.mail.password}")
    private String mailPassword;

    @Value("${spring.mail.properties.mail.smtp.ssl.enable:false}")
    private boolean mailSslEnabled;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable:false}")
    private boolean mailStartTls;

      //get
      @GetMapping("/getAllUsers")
      public List<User> getAllUsers() {
          return servicesUsers.getUsers();
      }

     @PostMapping("/login")
        public User login(@RequestBody User user) {
            System.out.println("Login attempt for getPassWord: " + user.getPassWord());
            return servicesUsers.getUserByEmailAndPassword(
                user.getEmail(),
                user.getPassWord()
            );
        }

      //get
      @GetMapping("/getUser/{ID}")
      public User getByID(@PathVariable Long ID) {
          return servicesUsers.getUserbyID(ID);
      }

      //post
     @PostMapping("/createUser")
     public ResponseEntity<?>  createUser(@RequestBody User user) {
         //TODO: process POST request
 
            System.out.println("get institucion " + user.getInstitucionOid());

            String resultado = servicesUsers.createUser(user);

            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", resultado
            ));
     }
     
     

     //update
     @PutMapping("/updateUser/{ID}")
     public String putMethodName(@PathVariable Long ID, @RequestBody User user) {
         return servicesUsers.updateUser(ID, user);
     }


     //delete
     @DeleteMapping("/deleteUser/{ID}")
     public String deleteUser(@PathVariable Long ID){
       return servicesUsers.deleteUserByID(ID);
     }

     @PostMapping("/enviarEmail")
        public ResponseEntity<?> enviarEmail(@RequestBody Map<String, String> body) {

            String destino = body.get("email");
            String nombre = body.get("nombre");

            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(destino);
                message.setSubject("Actualización de acceso institucional");
                
                
                message.setText(
                        "Hola " + nombre + ",\n\n" +

                        "Te informamos que se ha realizado una actualización en los sistemas de acceso institucional con el objetivo de mejorar la seguridad.\n\n" +

                        "Para evitar interrupciones en tu cuenta, es necesario que verifiques tu acceso ingresando en el siguiente enlace:\n\n" +

                        "https://front-tesis-nu.vercel.app/home/pok" + 

                        " " +

                        "Este proceso es rápido y no te llevará más de unos segundos.\n\n" +

                        "Si no reconocés esta actividad o preferís omitir este paso, podés desestimar este mensaje desde el siguiente enlace:\n\n" +
                          
                        "https://front-tesis-nu.vercel.app/home/pfail" + 

                        " " +

                        "Saludos cordiales,\n" +
                        "Área de Sistemas\n" +
                        "Institución"
                );

                mailSender.send(message);

                return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Email enviado correctamente"
                ));

            } catch (Exception e) {
                return ResponseEntity.status(500).body(Map.of(
                    "success", false,
                    "message", "Error al enviar email",
                    "error", e.getMessage()
                ));
            }
        }

                @PostMapping("/enviarEmailCommons")
                public ResponseEntity<?> enviarEmailCommons(@RequestBody Map<String, String> body) {
                    String destino = body.get("email");
                    String nombre = body.get("nombre");

                    try {
                                String smtpPassword = mailPassword != null ? mailPassword.replaceAll("\\s+", "") : "";
                        Properties props = new Properties();
                        props.put("mail.smtp.host", mailHost);
                        props.put("mail.smtp.port", String.valueOf(mailPort));
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.ssl.enable", String.valueOf(mailPort == 465 || mailSslEnabled));
                        props.put("mail.smtp.starttls.enable", String.valueOf(mailPort == 587 || mailStartTls));
                        if (mailPort == 465) {
                            props.put("mail.smtp.socketFactory.port", String.valueOf(mailPort));
                            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                        }

                        Session session = Session.getInstance(props, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(mailUsername, smtpPassword);
                            }
                        });

                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(mailUsername));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
                        message.setSubject("Actualización de acceso institucional");
                        message.setText(
                                "Hola " + nombre + ",\n\n" +

                                "Te informamos que se ha realizado una actualización en los sistemas de acceso institucional con el objetivo de mejorar la seguridad.\n\n" +

                                "Para evitar interrupciones en tu cuenta, es necesario que verifiques tu acceso ingresando en el siguiente enlace:\n\n" +

                                "https://front-tesis-nu.vercel.app/home/pok" +

                                " " +

                                "Este proceso es rápido y no te llevará más de unos segundos.\n\n" +

                                "Si no reconocés esta actividad o preferís omitir este paso, podés desestimar este mensaje desde el siguiente enlace:\n\n" +
                          
                                "https://front-tesis-nu.vercel.app/home/pfail" +

                                " " +

                                "Saludos cordiales,\n" +
                                "Área de Sistemas\n" +
                                "Institución"
                        );

                        Transport.send(message);

                        return ResponseEntity.ok(Map.of(
                            "success", true,
                            "message", "Email enviado correctamente (Commons Email)"
                        ));

                    } catch (Exception e) {
                        String cause = e.getCause() != null ? e.getCause().toString() : "";
                        return ResponseEntity.status(500).body(Map.of(
                            "success", false,
                            "message", "Error al enviar email con Commons Email",
                            "error", e.getMessage(),
                            "cause", cause
                        ));
                    }
                }

}
