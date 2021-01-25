package ma.zs.generated.ws.rest.provided.facade;

import io.swagger.annotations.Api;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.service.util.JwtUtil;
import ma.zs.generated.ws.rest.provided.converter.UserConverter;
import ma.zs.generated.ws.rest.provided.vo.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Authentication")
@RestController
@RequestMapping("generated/auth")
public class AuthRest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping(value = "/login")
    public String login(@RequestBody AuthRequest authRequest) throws Exception{
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
        }catch (Exception e){
		    throw new Exception("invalid credentials");
        }
		return jwtUtil.generateToken(authRequest.getEmail());


        //		Object result = userService.login(authRequest);
//		Map<String, Object> data = new HashMap<>();
//		if (result instanceof String) {
//			data.put("message", result);
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
//		}
//		data.put("message", "Logged in successfully");
//		data.put("user", result);
//		return ResponseEntity.status(HttpStatus.OK).body(userConverter.toVo((User) result));
    }


}