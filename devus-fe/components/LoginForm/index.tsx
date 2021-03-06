import { Divider, Space } from 'antd';
import { StyleLoginDiv, StyleSocialImage, StyleSocialDiv } from './style';

const LoginForm = () => {
  return (
    <div>
      <StyleLoginDiv>๐ ์์ ์ ํ ์ดํ๋ก์ ํธ๋ฅผ ์๋ํด๋ณด์ธ์!</StyleLoginDiv>
      <Divider plain>
        <h3>Social Login</h3>
      </Divider>
      <StyleSocialDiv>
        <Space size="large">
          <StyleSocialImage src="/images/social/naver.png" alt="๋ค์ด๋ฒ ๋ก๊ทธ์ธ" />
          <StyleSocialImage src="/images/social/kakao_128.png" alt="์นด์นด์ค ๋ก๊ทธ์ธ" />
          <StyleSocialImage src="/images/social/github_128.png" alt="๊นํ๋ธ ๋ก๊ทธ์ธ" />
        </Space>
      </StyleSocialDiv>
    </div>
  );
};

export default LoginForm;
