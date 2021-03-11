import { Post } from 'models/post';

export interface InitialState {
  posts: Array<Post>;
  loadPostLoading: boolean;
  loadPostDone: boolean;
  loadPostError: string | null;
}
