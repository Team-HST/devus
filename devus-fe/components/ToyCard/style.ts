import styled from 'styled-components';

export const StyleArticle = styled.article`
  width: 100%;
  max-width: 100%;
  height: 220px;
  margin-bottom: 1.5rem;
  display: flex !important;
  flex-direction: row;
  align-items: stretch !important;
  border-radius: 15px;
  overflow: hidden;
  transition: all 0.3s ease;
  box-shadow: 0 1px 1px 0 rgb(31 35 46 / 15%);

  @media only screen and (max-width: 480px) {
    width: 98%;
    max-width: 100%;
    margin: 2%;
    height: 100%;
    flex-direction: column;
  }
`;

type StyleCardImageProps = {
  url: string;
};

export const StyleCardImage = styled.a`
  width: 30%;
  max-width: 100%;
  min-height: 11rem;
  background-size: cover;
  background-position: 50% 50%;
  background-image: url(${(props: StyleCardImageProps) => props.url});

  @media only screen and (max-width: 480px) {
    width: 100%;
  }
`;

export const StyleContent = styled.div`
  padding: 1rem;
  width: 70%;
  background: white;

  @media only screen and (max-width: 480px) {
    width: 100%;
  }

  h2 {
    margin: 0 0 10px;
    font-size: 30px;
    font-weight: 400;
  }

  p {
    margin-top: 0;
    font-size: 14px;
    height: 55%;
  }
`;

export const StyleDate = styled.span`
  font-size: 13px;
  font-weight: bold;
`;
