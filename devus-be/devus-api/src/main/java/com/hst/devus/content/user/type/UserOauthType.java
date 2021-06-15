package com.hst.devus.content.user.type;

import java.util.Map;

import com.hst.devus.common.converter.EnumAttributeConverter;
import com.hst.devus.common.type.PersistableType;
import com.hst.devus.utils.EnumUtils;

import lombok.RequiredArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@RequiredArgsConstructor
public enum UserOauthType implements PersistableType<Integer> {
	GITHUB(0, "github", "깃헙 계정"),
	NAVER(1, "naver", "네이버 계정"),
	KAKAO(2, "kakao", "카카오 계정")
	;

	private static Map<Integer, UserOauthType> FIND = EnumUtils.asMap(UserOauthType.class);

	private final int code;
	private final String name;
	private final String description;

	@Override
	public Integer getCode() {
		return this.code;
	}

	@Override
	public String getCodeName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public static UserOauthType getType(int code) {
		return FIND.get(code);
	}

	public static class Converter extends EnumAttributeConverter<UserOauthType, Integer> {
		public Converter() {
			super(UserOauthType.class, false);
		}
	}
}
