import styled from 'styled-components';
import { Layout, Row } from 'antd';

const { Content } = Layout;

export const StyleRow = styled(Row)`
  height: 100vh;
  overflow: hidden;
`;

export const StyleContent = styled(Content)`
  overflow: auto;
  padding: 20px;
  height: 95vh;
`;
