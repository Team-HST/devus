import axios from 'axios';
import { Post } from 'models/post';

const getPostsAPI = (data: string) => {
  return axios.get<Post[]>(
    `https://jsonplaceholder.typicode.com/posts${data ? `?userId=${data}` : ''}`
  );
};

export default {
  getPostsAPI,
};
