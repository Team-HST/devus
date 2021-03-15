import { Row, Col } from 'antd';
import { StyleSearch } from './style';

const AppHeader = () => {
  return (
    <Row>
      <Col md={6} xs={6}>
        <h2>DevUs</h2>
      </Col>
      <Col md={18} xs={18}>
        <StyleSearch placeholder="검색 내용 입력" allowClear enterButton="검색" size="large" />
      </Col>
    </Row>
  );
};

export default AppHeader;
