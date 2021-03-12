import { HeartFilled } from '@ant-design/icons';
import { StyleArticle, StyleCardImage, StyleContent, StyleDate, StyleUsContDiv } from './style';

const ToyCard = () => {
  return (
    <StyleArticle>
      <StyleCardImage url="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png" />
      <StyleContent>
        <h2>DevUs toy project</h2>
        <p>
          Bring to the table win-win survival strategies to ensure proactive domination. At the end
          of the day, going forward, a new normal that has evolved from generation X is on the
          runway heading towards a streamlined cloud solution.
        </p>
        <StyleDate>2020.01.03</StyleDate>
        <StyleUsContDiv>
          <HeartFilled />
          1000
        </StyleUsContDiv>
      </StyleContent>
    </StyleArticle>
  );
};

export default ToyCard;
