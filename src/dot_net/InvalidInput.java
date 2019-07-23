package dot_net;

class InvalidInput extends Throwable {
    InvalidInput(String errorMsg) {
        super("Error: " + errorMsg);
    }
}
