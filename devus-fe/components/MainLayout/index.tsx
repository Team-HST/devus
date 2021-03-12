import { ReactNode } from 'react';
import LoginForm from 'components/LoginForm';
import { Layout, Col } from 'antd';
import { StyleRow, StyleContent } from './style';

const { Header } = Layout;

type MainLayoutProps = {
  children: ReactNode;
};

const MainLayout = ({ children }: MainLayoutProps) => {
  return (
    <StyleRow>
      <Col xs={24} md={6}>
        <LoginForm />
      </Col>
      <Col xs={24} md={18}>
        <Layout>
          <Header>Header</Header>
          <StyleContent style={{ background: '#e8eaef' }}>{children}</StyleContent>
        </Layout>
      </Col>
    </StyleRow>
  );
};

export default MainLayout;
