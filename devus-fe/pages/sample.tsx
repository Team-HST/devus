import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import useInput from 'hooks/useInput';
import * as postActions from 'store/reducers/post/action';
import { RootState } from 'store/reducers';

import { Input } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import PostCard from 'components/PostCard';

const SearchDiv = styled.div`
  width: 60%;
  margin: 10px auto;
`;

const Sameple = () => {
  const dispatch = useDispatch();
  const { posts } = useSelector((state: RootState) => state.post);
  const [searchText, onChangeSearchText] = useInput('');

  useEffect(() => {
    dispatch(postActions.requestPostAction());
  }, [dispatch]);

  const onSearch = () => {
    dispatch(postActions.requestPostAction(searchText));
  };

  return (
    <>
      <SearchDiv>
        <Input.Search
          size="large"
          placeholder="유저 아이디 입력"
          value={searchText}
          prefix={<SearchOutlined />}
          onChange={onChangeSearchText}
          onSearch={onSearch}
          allowClear
        />
      </SearchDiv>

      {posts.map((post) => (
        <PostCard key={post.id} post={post} />
      ))}
    </>
  );
};

export default Sameple;
