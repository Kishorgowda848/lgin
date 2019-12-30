//package com.app;
//
//import java.util.Optional;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ForgotPasswordRequest {
//@Autowired	
//private JwtUtil jwtUtil;
//@Autowired
//private  MyuserDetailService  myuserDetail ;
//@Autowired
//private UserRepository userRepository;
///** creating an one token **/
//
//@PostMapping("/forgot")
//public String forgotPasswordss(@RequestBody String username) {
// JSONObject json=new JSONObject(username);/** Json formate**/
// System.out.println(json.getString("usename"));
//	UserDetails userDetails= myuserDetail.loadUserByUsername(json.getString("usename")) ;/** geting username from table**/
//	 String token=jwtUtil.generateToken(userDetails);
//	 System.out.println(token);
//  	 Optional<Users> users=userRepository.findByUserName(json.getString("usename"));
//	 users.get().setToken(token);
//	 userRepository.save(users.get());
//	 return "true";
// 	 
// }
//	
//
//
//
//}
