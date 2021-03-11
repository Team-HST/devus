import styled from 'styled-components';
import { Card } from 'antd';
import { Post } from 'models/post';

type PostCardProps = {
  post: Post;
};

const ContentCard = styled(Card)`
  margin: 15px auto;
  width: 60%;
`;

const PostCard = ({ post }: PostCardProps) => {
  return (
    <ContentCard type="inner" title={`${post.title} ( userId: ${post.userId} )`}>
      {post.body}
    </ContentCard>
  );
};

export default PostCard;
