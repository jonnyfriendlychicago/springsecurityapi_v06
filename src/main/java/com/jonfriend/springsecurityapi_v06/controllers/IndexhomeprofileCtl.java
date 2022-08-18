//package com.jonfriend.springsecurityapi_v06.controllers;
//
//import com.jonfriend.springsecurityapi_v06.models.UserMdl;
//import com.jonfriend.springsecurityapi_v06.services.UserSrv;
//import com.jonfriend.springsecurityapi_v06.validator.UserValidator;
//import java.security.Principal;
//import java.util.Date;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@Controller
//public class IndexhomeprofileCtl {
//	
//	@Autowired
//	private UserSrv userSrv;
//	
//	@Autowired
//	private UserValidator userValidator;
//	
//	@RequestMapping("/register")
//    public String registerForm(
//    		@Valid @ModelAttribute("user") UserMdl userMdl
//    		) {
//        return "register.jsp";
//    }
//     
//    @PostMapping("/register")
//    public String registerPost(
//    		@Valid @ModelAttribute("user") UserMdl userMdl
//    		, BindingResult result
//    		, Model model
//    		, HttpSession session
//    		, HttpServletRequest request
//    		) {
//        
////    	if (result.hasErrors()) {
////            return "register.jsp";
////        }
//    	
//        // above is old project
//    	
//        userValidator.validate(userMdl, result);
//        
//     // Store the password before it is encrypted
//     	String password = userMdl.getPassword();
//        
//        if (result.hasErrors()) {
////        	return "loginPage.jsp";
//        	// above from platform, this doesn't seem right??
//        	return "register.jsp";
//        }
//        
//        // will this be the first user record?  if so, Make it... SUPER ADMIN!
//        if(userSrv.allUsers().size()==0) {
////        	userSrv.newUser(userMdl, "ROLE_SUPER_ADMIN");
//        	// above line temporarily replaced with below line, so that all users are the same
//        	userSrv.newUser(userMdl, "ROLE_USER");
//		} else {
//			userSrv.newUser(userMdl, "ROLE_USER");
//		}
//        
//        // Log in new user with the password we stored before encrypting it.  NOTE: the method listed immed below is built right after this mthd concludes
//     	authWithHttpServletRequest(request, userMdl.getEmail(), password);
//     		return "redirect:/";
//
//     	// end of method
//     	}
//    
//    // We call this new method below to automatically log in newly registered users
// 	public void authWithHttpServletRequest(
// 			HttpServletRequest request
// 			, String email
// 			, String password
// 			) {
// 	    try {
// 	        request.login(email, password);
// 	    } catch (ServletException e) {
// 	    	System.out.println("Error while login: " + e);
// 	    }
//    
// 	// end of method
// 	}
//  
// 	// JRF: temporarily disabling this upgrade user program. 
////    
////    @RequestMapping("/admin/{id}")
////    // JRF no idea (again...) why above says request mapping instead of post... doesn't make any sense, not sure if/how will work
////    // update on above: I think it's b/c they are doing this as a link instead of a form; same approach on the delete thing 
////	public String makeAdmin(
////			@PathVariable("id") Long userId
////			, Model model
////			) {
////		
////		UserMdl userMdl = userSrv.findById(userId);
////		userSrv.upgradeUser(userMdl);
////		
////		model.addAttribute("userList", userSrv.allUsers());
////		 
////		return "redirect:/admin";
////	}
//    
//    @RequestMapping("/login")
//    public String login(
//    		@ModelAttribute("user") UserMdl userMdl,
//    		// jrf: above from platform, but since we have sep log and user pages, I dont' think above is needed here, b/c it's only for register
//    		@RequestParam(value="error", required=false) String error, 
//    		@RequestParam(value="logout", required=false) String logout, 
//    		Model model
//    		) {
//        if(error != null) {
//            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
//        }
//        if(logout != null) {
//            model.addAttribute("logoutMessage", "Logout Successful.");
//        }
//        return "login.jsp";
//    }
//    
//    @RequestMapping(value = {"/", "/home"})
//    
//    public String home(
//    		Principal principal
//    		, Model model
//    		) {    	
//         
//        String email = principal.getName();
//		UserMdl userMdl = userSrv.findByEmail(email);
//		model.addAttribute("currentUser", userMdl);
//		
//		// JRF temporarily removing below: updating last login and substituting admin.jsp for home is not desired
////		if(userMdl!=null) {
////			userMdl.setLastLogin(new Date());
////			userSrv.updateUser(userMdl);
////			// If the user is an ADMIN or SUPER_ADMIN they will be redirected to the admin page
////			if(userMdl.getRoleMdl().get(0).getName().contains("ROLE_SUPER_ADMIN") || userMdl.getRoleMdl().get(0).getName().contains("ROLE_ADMIN")) {
////				model.addAttribute("currentUser", userSrv.findByEmail(email));
////				model.addAttribute("userList", userSrv.allUsers());
////				return "admin.jsp";
////			}
////			// All other users are redirected to the home page
////		}
//		
//        return "home.jsp";
//    }
//    
//    // JRF temporarily disabling this whole admin program
////    @RequestMapping("/admin")
////    public String adminDisplayPage(
////    		Principal principal
////    		, Model model
////    		) {
////    	
//////    	String username = principal.getName();
//////      above replaced by below
////    	String email = principal.getName();
////    	
//////    	model.addAttribute("currentUser", userSrv.findByUsername(username));
////    	// above replaced by below
////    	model.addAttribute("currentUser", userSrv.findByEmail(email));
////    	model.addAttribute("userList", userSrv.allUsers());
////    	
////    	return "admin.jsp";
////    }
//    
//    // JRF: temporarily disabling this 'delete users' program.
//    
////    @RequestMapping("/delete/{id}")
////	public String deleteUser(
////			@PathVariable("id") Long userId
////			, HttpSession session
////			, Model model
////			) {	
////		UserMdl userMdl = userSrv.findById(userId);
////		userSrv.deleteUser(userMdl);
////		
////		model.addAttribute("userList", userSrv.allUsers());
////		 
////		return "redirect:/admin";
////	}
//    
//    
//// end of ctl methods
//}
