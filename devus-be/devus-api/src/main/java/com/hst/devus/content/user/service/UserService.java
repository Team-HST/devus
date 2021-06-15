package com.hst.devus.content.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hst.devus.content.user.entity.User;
import com.hst.devus.content.user.exception.UserNotFoundException;
import com.hst.devus.content.user.repository.UserRepository;
import com.hst.devus.content.user.type.UserOauthType;
import com.hst.devus.content.user.ui.request.UserJoinRequest;

import lombok.RequiredArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	/**
	 * 사용자번호로 사용자 조회
	 * @param userNo 사용자 번호
	 * @return 조회된 유저
	 */
	public User getUser(Long userNo) {
		return userRepository.findById(userNo).orElseThrow(() -> new UserNotFoundException(userNo));
	}

	/**
	 * 어스네임으로 사용자 조회
	 * @param usname 어스네임
	 * @return 조회된 유저
	 */
	public User getUserByUsname(String usname) {
		return userRepository.findByUsname(usname).orElseThrow(() -> new UserNotFoundException(usname));
	}

	/**
	 * 이메일과 OAuth타입으로 사용자 조회
	 * @param email 이메일
	 * @param oauthType oAuthType
	 * @return 조회된 유저
	 */
	public User getUserByEmailAndOauthType(String email, UserOauthType oauthType) {
		return userRepository.findByEmailAndOauthType(email, oauthType)
			.orElseThrow(() -> new UserNotFoundException(email, oauthType));
	}

	/**
	 * 어스네임 중복체크
	 * @param usname 어스네임
	 * @return 중복여부
	 */
	public boolean isAlreadyExistUsname(String usname) {
		try {
			getUserByUsname(usname);
		} catch (UserNotFoundException e) {
			return false;
		}
		return true;
	}

	/**
	 * 사용자 회원 가입
	 * @param request 가입 요청 정보
	 * @return 가입된 회원 정보
	 */
	@Transactional
	public User joinUser(UserJoinRequest request) {
		User createdUser = User.builder()
			.email(request.getEmail())
			.oauthType(UserOauthType.getType(request.getOAuthType()))
			.usname(request.getUsname())
			.build();
		createdUser.changeProfileImageUrl(request.getProfileImageUrl());
		return userRepository.save(createdUser);
	}

}
