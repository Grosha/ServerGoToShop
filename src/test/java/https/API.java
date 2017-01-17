package https;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

public class API {

    public OkHttpClient httpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient httpClient = null;
        try {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .sslSocketFactory(getSSLSocketFactory())
                    .hostnameVerifier(getHostnameVerifier())
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return httpClient;
    }

    private static SSLSocketFactory sslSocketFactory;

    public static SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        if (sslSocketFactory == null) {
            TrustManager[] tm = new TrustManager[]{new X509TrustManager() {


                public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            }};
            // Create an SSLContext that uses our TrustManager
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, tm, new SecureRandom());
            sslSocketFactory = context.getSocketFactory();
        }
        return sslSocketFactory;
    }


    private static HostnameVerifier hostnameVerifier;


    public static HostnameVerifier getHostnameVerifier() {
        if (hostnameVerifier == null) {
            hostnameVerifier = new HostnameVerifier() {
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            };
        }
        return hostnameVerifier;
    }
}
