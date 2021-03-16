import styled from 'styled-components';

export const StyleWrapperDiv = styled.div`
  margin: 30px 50px 50px 70px;
  border: 0 solid currentColor;

  h1 {
    font-weight: 900;
    word-wrap: break-word;
    font-size: 2rem;
    font-family: Source Sans Pro, sans-serif;
  }

  h2 {
    font-size: 1rem;
    line-height: 1;
    font-weight: 300;
    font-family: Source Sans Pro, sans-serif;
  }
`;

export const StyleProfileImageDiv = styled.div`
  position: relative;
  display: inline-block;
`;

export const StyleUserImg = styled.img`
  width: 11rem;
  height: 11rem;
  object-fit: cover;
  z-index: 1;
  position: relative;
  border: 0 solid currentColor;
  border-radius: 50%;
`;

export const StyleColorDiv = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  border-radius: 50%;
  background-color: #021446;
  transform: translateX(35%);
`;

export const StyleUserInfoDiv = styled.div`
  font-size: 1rem;
  font-weight: 500;
  margin-top: 20px;
`;
