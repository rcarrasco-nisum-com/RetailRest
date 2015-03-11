package nisum.errorResource;

public enum ExecptionsEnum {

    PRODUCT_TYPE_ID_NOT_FOUND_EXCEPTION("ProductTypeIdNotFoundException",
            "Id does not exist the product type with ID:"),

    PRODUCT_ID_NOT_FOUND_EXCEPTION("ProductIdNotFoundException",
                                                "Id does not exist the product with ID:");

    private final String exceptionName;

    private final String exceptionPhrase;


    private ExecptionsEnum(String exceptionName, String exceptionPhrase) {
        this.exceptionName = exceptionName;
        this.exceptionPhrase = exceptionPhrase;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String getExceptionPhrase() {
        return exceptionPhrase;
    }
}
