import java.io.FileNotFoundException;
import java.io.IOException;

public class Week8Task2 {
    public void nullPointerEx() {
        throw new NullPointerException("Lỗi Null Pointer");
    }

    /**xuw li.*/
    public String nullPointerExTest() {
        try {
            nullPointerEx();
            return "";
        } catch (NullPointerException e) {
            return e.getMessage();
        }
    }

    public void arrayIndexOutOfBoundsEx() {
        throw new ArrayIndexOutOfBoundsException("Lỗi Array Index Out of Bounds");
    }

    /**xuw li.*/
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
            return "";
        } catch (ArrayIndexOutOfBoundsException e) {
            return e.getMessage();
        }
    }

    public void arithmeticEx() {
        throw new ArithmeticException("Lỗi Arithmetic");
    }

    /**xuw li.*/
    public String arithmeticExTest() {
        try {
            arithmeticEx();
            return "";
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
    }

    public void fileNotFoundEx() throws FileNotFoundException {
        throw new FileNotFoundException("Lỗi File Not Found");
    }

    /**xuw li.*/
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
            return "";
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
    }

    public void ioEx() throws IOException {
        throw new IOException("Lỗi IO");
    }

    /**xuw li.*/
    public String ioExTest() {
        try {
            ioEx();
            return "";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

}
