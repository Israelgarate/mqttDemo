import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;

public class CertificateAuthTest {

    public static void main(String args[]) throws AWSIotException {

        String clientEndpoint = "ai8qa4t0mm12e.iot.us-east-1.amazonaws.com";   // use value returned by describe-endpoint --endpoint-type "iot:Data-ATS"
        String clientId = "client1";                              // replace with your own client ID. Use unique client IDs for concurrent connections.
        String certificateFile = "src/test/java/479dae9d03e4c44a017bdf806ef3e726d748977cb5c0b0091b405e323b07daa8-certificate.pem.crt";                       // X.509 based certificate file
        String privateKeyFile = "src/test/java/479dae9d03e4c44a017bdf806ef3e726d748977cb5c0b0091b405e323b07daa8-private.pem.key";                        // PKCS#1 or PKCS#8 PEM encoded private key file

// SampleUtil.java and its dependency PrivateKeyReader.java can be copied from the sample source code.
// Alternatively, you could load key store directly from a file - see the example included in this README.
        SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certificateFile, privateKeyFile);
        AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, pair.keyStore, pair.keyPassword);

// optional parameters can be set before connect()
        client.connect();
        System.out.println("Conectado");


    }

}
