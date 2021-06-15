package com.hst.devus.content.user.ui;

import org.springdoc.core.SpringDocUtils;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hst.devus.configuration.props.ApplicationProperties;
import com.hst.devus.content.user.entity.User;
import com.hst.devus.content.user.service.UserService;
import com.hst.devus.content.user.type.UserOauthType;
import com.hst.devus.content.user.ui.request.UserJoinRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dlgusrb0808@gmail.com
 */
@Tag(name = "사용자 API", description = "사용자 관련 API")
@RestController
@RequestMapping("users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

	private final ApplicationProperties applicationProperties;
	private final UserService userService;

	static {
		SpringDocUtils.getConfig().addAnnotationsToIgnore(
			RequestParam.class,
			PageableDefault.class,
			PathVariable.class
		);
	}

	@Operation(
		summary = "사용자 조회 by userNo",
		parameters = {
			@Parameter(name = "userNo", in = ParameterIn.PATH, schema = @Schema(implementation = Long.class))
		}
	)
	@GetMapping("by-no/{userNo}")
	public ResponseEntity<User> getUser(@PathVariable Long userNo) {
		return ResponseEntity.ok(userService.getUser(userNo));
	}

	@Operation(
		summary = "사용자 조회 by usname",
		parameters = {
			@Parameter(name = "usname", in = ParameterIn.PATH, schema = @Schema(implementation = String.class))
		}
	)
	@GetMapping("by-usname/{usname}")
	public ResponseEntity<User> getUserByUsname(@PathVariable String usname) {
		log.info("usName : {}", usname);
		return ResponseEntity.ok(userService.getUserByUsname(usname));
	}

	@Operation(
		summary = "사용자 조회 by email & oauthType",
		parameters = {
			@Parameter(name = "email", in = ParameterIn.PATH, schema = @Schema(implementation = String.class)),
			@Parameter(name = "oauthType", in = ParameterIn.PATH, schema = @Schema(implementation = Integer.class)),
		}
	)
	@GetMapping("by-email-oauth-type/{email}/{oauthType}")
	public ResponseEntity<User> getUserByEmailAndOauthType(@PathVariable String email, @PathVariable Integer oauthType) {
		return ResponseEntity.ok(userService.getUserByEmailAndOauthType(email, UserOauthType.getType(oauthType)));
	}

	@Operation(
		summary = "사용자 회원 가입"
	)
	@PostMapping
	public ResponseEntity<User> join(@RequestBody UserJoinRequest request) {
		return ResponseEntity.ok(userService.joinUser(request));
	}

}
