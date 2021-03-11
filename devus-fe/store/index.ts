import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import { createWrapper } from 'next-redux-wrapper';
import logger from 'redux-logger';
import createSagaMiddlewere from 'redux-saga';
import rootReducer from './reducers';
import rootSaga from './sagas';

const sagaMiddleware = createSagaMiddlewere();
const middleware = [...getDefaultMiddleware(), sagaMiddleware];
// development인 경우 logger 미들웨어 추가
if (process.env.NODE_ENV === 'development') middleware.push(logger);

const store = () => {
  const configStore = configureStore({
    reducer: rootReducer,
    middleware,
    devTools: process.env.NODE_ENV === 'development',
  });
  sagaMiddleware.run(rootSaga);

  return configStore;
};

const wrapper = createWrapper(store, { debug: process.env.NODE_ENV === 'development' });

export default wrapper;
