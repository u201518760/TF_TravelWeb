package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TravelWebApplication  implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(TravelWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password="123456";
		String contraseña1="contra1";
		String contraseña2="contra2";
		String contraseña3="contra3";
		String contraseña4="contra4";
		String contraseña5="contra5";
		String contraseña6="contra6";
		String contraseña7="contra7";
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
		}
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(contraseña1);
			System.out.println(bcryptPassword);
		}
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(contraseña2);
			System.out.println(bcryptPassword);
		}
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(contraseña3);
			System.out.println(bcryptPassword);
		}
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(contraseña4);
			System.out.println(bcryptPassword);
		}
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(contraseña5);
			System.out.println(bcryptPassword);
		}
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(contraseña6);
			System.out.println(bcryptPassword);
		}
		for(int i=0;i<1;i++) {
			String bcryptPassword=passwordEncoder.encode(contraseña7);
			System.out.println(bcryptPassword);
		}
		
		
	}

}
