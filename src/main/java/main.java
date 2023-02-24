import io.github.spencerpark.jupyter.channels.JupyterConnection;
import io.github.spencerpark.jupyter.channels.JupyterSocket;
import io.github.spencerpark.jupyter.kernel.KernelConnectionProperties;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

public class main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("No connection file given as argument");

        }

        Path connectionFile = Paths.get(args[0]);
        if (!Files.isRegularFile(connectionFile)) {
            throw new IllegalArgumentException("Given file '"+ connectionFile +"' is not really a file");
        }

        String contents = new String(Files.readAllBytes(connectionFile));

        JupyterSocket.JUPYTER_LOGGER.setLevel(Level.WARNING);

        KernelConnectionProperties connProps = KernelConnectionProperties.parse(contents);
        JupyterConnection connection = new JupyterConnection(connProps);

        var kernel = new EpsilonKernel();
        kernel.becomeHandlerForConnection(connection);

        connection.connect();
        connection.waitUntilClose();
    }
}
