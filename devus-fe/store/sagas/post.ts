import { all, fork, call, put, takeLatest } from 'redux-saga/effects';
import { AxiosResponse } from 'axios';
import { Post } from 'models/post';
import postService from 'apis/post';
import * as actions from '../reducers/post/action';

function* loadPost(data) {
  try {
    const result: AxiosResponse<Post[]> = yield call(postService.getPostsAPI, data.payload);
    yield put(actions.successPostAction(result.data));
  } catch (error) {
    console.error(error);
    yield put(actions.failurePostAction(error.response.data));
  }
}

function* watchLoadPost() {
  yield takeLatest(actions.requestPostAction.type, loadPost);
}

function* postSaga() {
  yield all([fork(watchLoadPost)]);
}

export default postSaga;
