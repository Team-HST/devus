package com.hst.devus.content.user.ui.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class UserJoinRequest {
	@Schema(title = "이메일", description = "여행 제목", required = true)
	private String email;
	@Schema(title = "인증 타입", description = "git(0), naver(1), kakao(2)", required = true)
	private int oAuthType;
	@Schema(title = "어스네임", description = "어스네임", required = true)
	private String usname;
	@Schema(title = "프로필 이미지 URL", description = "여행 제목")
	private String profileImageUrl;
}
