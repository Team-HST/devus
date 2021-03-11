import { HYDRATE } from 'next-redux-wrapper';
import { combineReducers } from '@reduxjs/toolkit';

import post from './post/reducer';

const combinedReducer = combineReducers({
  post,
});

const rootReducer = (state, action) => {
  switch (action.type) {
    case HYDRATE:
      return action.payload;
    default: {
      return combinedReducer(state, action);
    }
  }
};

export type RootState = ReturnType<typeof combinedReducer>;

export default rootReducer;
