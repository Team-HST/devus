import { createAction } from '@reduxjs/toolkit';
import { Post } from 'models/post';

export const requestPostAction = createAction<string>('LOAD_POST_REQUEST');
export const successPostAction = createAction<Post[]>('LOAD_POST_SUCCESS');
export const failurePostAction = createAction<string>('LOAD_POST_FAILURE');
