import styled from 'styled-components';
import { Layout, Row } from 'antd';

const { Content } = Layout;

export const StyleRow = styled(Row)`
  overflow: auto;
  height: 100vh;
`;

export const StyleContent = styled(Content)`
  padding: 20px;
  height: 80%;
`;
