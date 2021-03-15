import styled from 'styled-components';
import { Layout, Row } from 'antd';

const { Header, Content } = Layout;

export const StyleLayout = styled(Layout)`
  background-color: #e8eaef;
`;

export const StyleHeader = styled(Header)`
  background-color: #e8eaef;
`;

export const StyleRow = styled(Row)`
  height: 100vh;
  overflow: hidden;
`;

export const StyleContent = styled(Content)`
  overflow: auto;
  padding: 20px;
  height: 95vh;
`;
