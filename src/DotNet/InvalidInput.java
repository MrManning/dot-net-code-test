package DotNet;

class InvalidInput extends Throwable {
    InvalidInput(String errorMsg) {
        super("Error: " + errorMsg);
    }
}
