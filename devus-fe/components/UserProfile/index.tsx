import { ProjectOutlined, HomeOutlined, LinkOutlined } from '@ant-design/icons';
import {
  StyleWrapperDiv,
  StyleProfileImageDiv,
  StyleUserImg,
  StyleColorDiv,
  StyleUserInfoDiv,
} from './style';

const UserProfile = () => {
  return (
    <StyleWrapperDiv>
      <h2>Web Developer</h2>
      <h1>Scott Johnson</h1>
      <StyleProfileImageDiv>
        <StyleUserImg src="images/profile.jpg" alt="유저 이미지" />
        <StyleColorDiv />
      </StyleProfileImageDiv>
      <StyleUserInfoDiv>
        <div>
          <ProjectOutlined /> 회사주소
        </div>
        <div>
          <HomeOutlined /> 집주소
        </div>
        <div>
          <LinkOutlined /> 링크
        </div>
      </StyleUserInfoDiv>
    </StyleWrapperDiv>
  );
};

export default UserProfile;
