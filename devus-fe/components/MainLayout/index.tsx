import { ReactNode } from 'react';
import AppHeader from 'components/AppHeader';
import LoginForm from 'components/LoginForm';
import { Layout, Col } from 'antd';
import { StyleLayout, StyleHeader, StyleRow, StyleContent } from './style';

const { Content } = Layout;

type MainLayoutProps = {
  children: ReactNode;
};

const MainLayout = ({ children }: MainLayoutProps) => {
  return (
    <StyleLayout>
      <StyleHeader>
        <AppHeader />
      </StyleHeader>
      <Content>
        <StyleRow>
          <Col xs={24} md={6}>
            <LoginForm />
          </Col>
          <Col xs={24} md={18}>
            <StyleContent>{children}</StyleContent>
          </Col>
        </StyleRow>
      </Content>
    </StyleLayout>
  );
};

export default MainLayout;
