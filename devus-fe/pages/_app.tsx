import { AppProps } from 'next/app';
import Head from 'next/head';
import GlobalStyles from 'components/GlobalStyles';
import 'antd/dist/antd.css';

import wrapper from 'store';

const DevUs = ({ Component, pageProps }: AppProps) => {
  return (
    <>
      <GlobalStyles />
      <Head>
        <meta charSet="utf-8" />
        <title>devus</title>
      </Head>
      <Component {...pageProps} />
    </>
  );
};

export default wrapper.withRedux(DevUs);
