package com.hst.devus.content.user.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hst.devus.content.user.type.UserOauthType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "USER")
@EntityListeners({AuditingEntityListener.class})
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NO")
	private Long no;

	@Column(name = "USER_EMAIL")
	private String email;

	@Convert(converter = UserOauthType.Converter.class)
	@Column(name = "USER_OAUTH_TYPE")
	private UserOauthType oauthType;

	@Column(name = "USER_USNM")
	private String usname;

	@CreatedDate
	@Column(name = "CREATE_AT")
	private LocalDateTime createAt;

	@LastModifiedDate
	@Column(name = "MODIFY_AT")
	private LocalDateTime modifyAt;

	@Column(name = "USER_NM")
	private String name;

	@Column(name = "USER_COMPANY")
	private String company;

	@Column(name = "USER_AREA")
	private String area;

	@Column(name = "USER_IMAGE_URL")
	private String profileImageUrl;

	@Column(name = "USER_SELF_INTRO")
	private String selfIntro;

	@Column(name = "USER_WORK_FIELD")
	private String workField;

	@Column(name = "USER_HOMEPAGE_URL")
	private String homepageUrl;

	@Transient
	private final Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

	@Builder
	public User(String email, UserOauthType oauthType, String usname) {
		this.email = email;
		this.oauthType = oauthType;
		this.usname = usname;
	}

	/**
	 * ????????? ?????? ??????
	 * @param name ????????? ??????
	 */
	public void changeName(String name) {
		this.name = name;
	}

	/**
	 * ????????? ????????? ??????
	 * @param profileImageUrl ????????? ????????? ????????? URL
	 */
	public void changeProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	/**
	 * ????????? ?????? ??????
	 * @param company ??????
	 * @param area ??????
	 * @param selfIntro ????????????
	 * @param workField ????????????
	 * @param homepageUrl ???????????? URL
	 */
	public void changeCareer(String company, String area, String selfIntro, String workField, String homepageUrl) {
		this.company = company;
		this.area = area;
		this.selfIntro = selfIntro;
		this.workField = workField;
		this.homepageUrl = homepageUrl;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return String.valueOf(this.no);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
