import styled from 'styled-components';
import { Input } from 'antd';

const { Search } = Input;

export const StyleSearch = styled(Search)`
  margin-top: 12px;
  margin-left: 5px;
  overflow: hidden;
  border-radius: 12px;

  button {
    background-color: #021446;
  }
`;
