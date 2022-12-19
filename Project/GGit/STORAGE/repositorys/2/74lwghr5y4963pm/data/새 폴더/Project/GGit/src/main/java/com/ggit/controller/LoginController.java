package com.ggit.controller;



import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.MemberService;
import com.ggit.vo.MemberVo;


@RestController
public class LoginController {
    @Autowired
    public MemberVo memberVo;

    @Autowired
    public MemberService memberService;

    @Value("${spring.mail.username}")
    private String naver_id;

    @Value("${spring.mail.password}")
    private String naver_pw;

    @PostMapping("/login")
    @ResponseBody
    public MemberVo login(@RequestBody MemberVo membervo) {
        return memberVo = memberService.memberByemailPw(membervo);
    }

    @PostMapping("/signup")
    @ResponseBody
    public int signup(@RequestBody MemberVo membervo) {
        return memberService.signupMember(membervo);
    }

    @PostMapping("/emailsender")
    public String emailsender(@RequestBody MemberVo membervo) {
    
        Properties p = System.getProperties();
		
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.naver.com");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.port", "587");
 
        Authenticator auth = new MyAuthentication();

        Session session = Session.getInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);

        // 랜덤 숫자+영어 생성
        Random rand = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<7; i++){
            if(rand.nextBoolean()){
                sb.append((char)((int)(rand.nextInt(26))+97));
            }else{
                sb.append((rand.nextInt(10)));
            }
        }
 
        try {
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress();
            
            from = new InternetAddress("<0205ryeol@naver.com>"); 
            msg.setFrom(from);
 
            InternetAddress to = new InternetAddress(membervo.getEmail()); 
            msg.setRecipient(Message.RecipientType.TO, to);

            msg.setSubject("[GGit] - 이메일 인증", "UTF-8"); 
            msg.setText("<h1>인증 코드입니다.</h1><br> <p>"+ sb +"</p>", "UTF-8"); 
            msg.setHeader("content-Type", "text/html");
 
            javax.mail.Transport.send(msg);
            System.out.println("전송 완료");
            
        } catch (AddressException addr_e){
            addr_e.printStackTrace();
        } catch (MessagingException msg_e){
            msg_e.printStackTrace();
        }

        return sb+"";

	} // 

     class MyAuthentication extends Authenticator {
	 
        PasswordAuthentication account;
    
        public MyAuthentication(){
            String id = naver_id; // 네이버 아이디 
            String pw = naver_pw; // 네이버 비밀번호 
            account = new PasswordAuthentication(id, pw);
        }
    
        public PasswordAuthentication getPasswordAuthentication(){
            return account;
        }
    }
        

        


}
