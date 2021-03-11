import { createReducer, PayloadAction } from '@reduxjs/toolkit';
import { Post } from 'models/post';
import * as actions from './action';
import { InitialState } from './type';

const initialState: InitialState = {
  posts: [],
  loadPostLoading: false,
  loadPostDone: false,
  loadPostError: null,
};

const reducer = createReducer<InitialState>(initialState, (builder) => {
  builder.addCase(actions.requestPostAction, (state) => {
    state.loadPostLoading = true;
    state.loadPostDone = false;
    state.loadPostError = null;
  });
  builder.addCase(actions.successPostAction, (state, { payload: posts }: PayloadAction<Post[]>) => {
    state.posts = posts;
    state.loadPostLoading = false;
    state.loadPostDone = true;
    state.loadPostError = null;
  });
  builder.addCase(actions.failurePostAction, (state, { payload: error }: PayloadAction<string>) => {
    state.loadPostLoading = false;
    state.loadPostDone = false;
    state.loadPostError = error;
  });
});

export default reducer;
