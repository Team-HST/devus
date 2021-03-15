import { Divider, Space } from 'antd';
import { StyleLoginDiv, StyleSocialImage, StyleSocialDiv } from './style';

const LoginForm = () => {
  return (
    <div>
      <StyleLoginDiv>👋 자신의 토이프로젝트를 자랑해보세요!</StyleLoginDiv>
      <Divider plain>
        <h3>Social Login</h3>
      </Divider>
      <StyleSocialDiv>
        <Space size="large">
          <StyleSocialImage src="/images/social/naver.png" alt="네이버 로그인" />
          <StyleSocialImage src="/images/social/kakao_128.png" alt="카카오 로그인" />
          <StyleSocialImage src="/images/social/github_128.png" alt="깃허브 로그인" />
        </Space>
      </StyleSocialDiv>
    </div>
  );
};

export default LoginForm;
