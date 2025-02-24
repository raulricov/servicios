package controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import model.ParametrosToken;
import model.RespuestaGetToken;
import model.RespuestaToken;

@RestController
public class GetTokenController {
	
	@Autowired
	WebClient webClient;
	
	String url = "http://localhost:8080";
	String username = "auth-vivelibre";
	String password = "password";
	
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping(value = "/get-token", produces = MediaType.APPLICATION_JSON_VALUE)
	public RespuestaGetToken getToken() {
		
		ParametrosToken parametrosToken = new ParametrosToken(username, password);
		
		RespuestaToken respuestaToken = webClient
		.post()  
		.uri(url + "/token")  
		.contentType(MediaType.APPLICATION_JSON)  
		.bodyValue(parametrosToken)  
		.retrieve()  
		.bodyToMono(RespuestaToken.class)
		.block();
				
		RespuestaGetToken respuestaGetToken = this.generateRespuestaGetToken(respuestaToken.getToken());
		return respuestaGetToken;
	}
	
	private RespuestaGetToken generateRespuestaGetToken(String token) {
		
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sm.format(new Date());		
		RespuestaGetToken respuestaGetToken = new RespuestaGetToken(token, strDate);
		return respuestaGetToken;
	}
}
