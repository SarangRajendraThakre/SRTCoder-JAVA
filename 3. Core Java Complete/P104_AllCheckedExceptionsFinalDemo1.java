// ======== MAIN DEMO CLASS ========
import javax.sound.midi.MidiUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.crypto.URIReferenceException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathException;
import javax.print.*;
import javax.naming.NamingException;
import java.awt.AWTException;
import java.awt.FontFormatException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.NotBoundException;
import java.rmi.server.ServerNotActiveException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.concurrent.*;
import java.util.zip.DataFormatException;
import org.xml.sax.SAXException;
import javax.script.ScriptException;
import java.util.TooManyListenersException;

// ======== FAKE CLASSES FOR REMOVED JAVA EE/CORBA EXCEPTIONS ========
class JAXBException extends Exception {
    public JAXBException(String msg) { super(msg); }
}

class MarshalException extends JAXBException {
    public MarshalException(String msg) { super(msg); }
}

class MimeTypeParseException extends Exception {
    public MimeTypeParseException(String msg) { super(msg); }
}

class RemarshalException extends Exception {
    public RemarshalException() { super("Remarshal error"); }
}

class SOAPException extends Exception {
    public SOAPException(String msg) { super(msg); }
}

class UserException extends Exception {
    public UserException(String msg) { super(msg); }
}

public class P104_AllCheckedExceptionsFinalDemo1 {

    public static void main(String[] args) {
        P104_AllCheckedExceptionsFinalDemo1 demo = new P104_AllCheckedExceptionsFinalDemo1();
        demo.runAll();
    }

    void runAll() {
        run("IOException", () -> { throw new IOException("File not found"); });
        run("SQLException", () -> { throw new SQLException("DB connection failed"); });
        run("InterruptedException", () -> { throw new InterruptedException("Thread interrupted"); });
        run("CloneNotSupportedException", () -> { throw new CloneNotSupportedException("Clone not supported"); });
        run("DataFormatException", () -> { throw new DataFormatException("Invalid data format"); });
        run("DatatypeConfigurationException", () -> { throw new DatatypeConfigurationException("Invalid datatype"); });
        run("ExecutionException", () -> { throw new ExecutionException("Execution failed", null); });
        run("FontFormatException", () -> { throw new FontFormatException("Bad font file"); });
        run("GeneralSecurityException", () -> { throw new GeneralSecurityException("Security error"); });
        run("InvalidPreferencesFormatException", () -> { throw new java.util.prefs.InvalidPreferencesFormatException(new IOException("Invalid XML")); });
        run("JAXBException", () -> { throw new JAXBException("JAXB issue"); });
        run("MarshalException", () -> { throw new MarshalException("Marshal error"); });
        run("MidiUnavailableException", () -> { throw new MidiUnavailableException("MIDI device unavailable"); });
        run("MimeTypeParseException", () -> { throw new MimeTypeParseException("Invalid MIME type"); });
        run("NamingException", () -> { throw new NamingException("Naming error"); });
        run("NoninvertibleTransformException", () -> { throw new java.awt.geom.NoninvertibleTransformException("Matrix not invertible"); });
        run("NotBoundException", () -> { throw new NotBoundException("Not bound"); });
        run("ParseException", () -> { throw new ParseException("Parse failed", 0); });
        run("ParserConfigurationException", () -> { throw new ParserConfigurationException("Parser config error"); });
        run("PrinterException", () -> { throw new java.awt.print.PrinterException("Printer not found"); });
        run("PrintException", () -> { throw new PrintException("Print error"); });
        run("PropertyVetoException", () -> { throw new PropertyVetoException("Change vetoed", null); });
        run("ReflectiveOperationException", () -> { throw new ReflectiveOperationException("Reflection failed"); });
        run("RemarshalException", () -> { throw new RemarshalException(); });
        run("SAXException", () -> { throw new SAXException("SAX parsing failed"); });
        run("ScriptException", () -> { throw new ScriptException("Script execution failed"); });
        run("ServerNotActiveException", () -> { throw new ServerNotActiveException("Server not active"); });
        run("SOAPException", () -> { throw new SOAPException("SOAP error"); });
        run("TimeoutException", () -> { throw new TimeoutException("Timeout occurred"); });
        run("TooManyListenersException", () -> { throw new TooManyListenersException("Too many listeners"); });
        run("TransformerException", () -> { throw new TransformerException("Transformation failed"); });
        run("UnmodifiableClassException", () -> { throw new java.lang.instrument.UnmodifiableClassException("Class unmodifiable"); });
        run("UnsupportedAudioFileException", () -> { throw new UnsupportedAudioFileException("Audio format not supported"); });
        run("UnsupportedCallbackException", () -> { throw new javax.security.auth.callback.UnsupportedCallbackException(null, "Callback not supported"); });
        run("UnsupportedFlavorException", () -> { throw new UnsupportedFlavorException(DataFlavor.imageFlavor); });
        run("UnsupportedLookAndFeelException", () -> { throw new javax.swing.UnsupportedLookAndFeelException("Look and feel not supported"); });
        run("URIReferenceException", () -> { throw new URIReferenceException("URI reference error"); });
        run("URISyntaxException", () -> { throw new URISyntaxException("http://bad uri", "Invalid URI"); });
        run("UserException", () -> { throw new UserException("User-defined CORBA exception"); });
        run("XAException", () -> { throw new javax.transaction.xa.XAException("XA error"); });
        run("XMLSignatureException", () -> { throw new XMLSignatureException("XML signature failed"); });
        run("XMLStreamException", () -> { throw new XMLStreamException("XML stream error"); });
        run("XPathException", () -> { throw new XPathException("XPath evaluation failed"); });
        run("AWTException", () -> { throw new AWTException("AWT error"); });
    }

    void run(String name, ExceptionThrower code) {
        try {
            code.run();
        } catch (Exception e) {
            System.out.println("[" + name + "] → " + e);
        }
    }

    @FunctionalInterface
    interface ExceptionThrower {
        void run() throws Exception;
    }
}
