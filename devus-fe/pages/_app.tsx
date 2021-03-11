import { AppProps } from 'next/app';
import Head from 'next/head';
import 'antd/dist/antd.css';

import wrapper from 'store';

const DevUs = ({ Component, pageProps }: AppProps) => {
  return (
    <>
      <Head>
        <meta charSet="utf-8" />
        <title>devus</title>
      </Head>
      <Component {...pageProps} />
    </>
  );
};

export default wrapper.withRedux(DevUs);
